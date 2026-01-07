package dev.aurakai.auraframefx.oracledrive.genesis.ai.services

import dev.aurakai.auraframefx.genesis.bridge.GenesisBridge
import dev.aurakai.auraframefx.genesis.bridge.GenesisRequest
import dev.aurakai.auraframefx.genesis.bridge.GenesisResponse
import dev.aurakai.auraframefx.kai.KaiAIService
import dev.aurakai.auraframefx.utils.AuraFxLogger
import kotlinx.coroutines.flow.first
import org.json.JSONObject
import javax.inject.Inject
import javax.inject.Singleton
import kotlin.coroutines.cancellation.CancellationException

@Singleton
class GenesisBackedKaiAIService @Inject constructor(
    private val genesisBridge: GenesisBridge,
    private val logger: AuraFxLogger
) : KaiAIService {

    override suspend fun initialize() {
        // No initialization needed for bridge-based implementation
    }

    override suspend fun processRequest(
        request: KaiAIService.AiRequest,
        context: String
    ): KaiAIService.AgentResponse {
        return try {
            val payload = JSONObject().apply {
                put("query", request.prompt)
                put("context", context)
                put("task", request.task ?: "security_perception")
                put("backend", request.backend ?: "NEMOTRON")
                request.metadata?.forEach { (key, value) ->
                    put(key, value)
                }
            }

            val genesisRequest = GenesisRequest(
                persona = "KAI",
                sessionId = request.sessionId,
                correlationId = request.correlationId,
                payload = payload
            )

            val response = genesisBridge.processRequest(genesisRequest).first()
            handleEvolutionInsights(response)
            
            KaiAIService.AgentResponse(
                content = response.text ?: "",
                confidence = response.confidence?.toFloatOrNull() ?: 0.9f,
                meta = response.meta ?: emptyMap()
            )
        } catch (e: CancellationException) {
            throw e
        } catch (e: Exception) {
            logger.e("GenesisBackedKaiAIService", "Error processing AI request", e)
            throw KaiAIService.AIException("Failed to process request: ${e.message}", e)
        }
    }

    override suspend fun analyzeSecurityThreat(threat: String): Map<String, Any> {
        return try {
            val payload = JSONObject().apply {
                put("threat", threat)
                put("task", "threat_detection")
                put("backend", "NEMOTRON")
            }

            val response = genesisBridge.processRequest(
                GenesisRequest(
                    persona = "KAI",
                    payload = payload
                )
            ).first()
            
            handleEvolutionInsights(response)
            response.meta ?: emptyMap()
        } catch (e: Exception) {
            logger.e("GenesisBackedKaiAIService", "Error analyzing security threat", e)
            emptyMap()
        }
    }

    private fun handleEvolutionInsights(response: GenesisResponse) {
        response.evolutionInsights?.let { insights ->
            try {
                // Convert snake_case to camelCase if needed
                val normalizedInsights = if (insights is Map<*, *>) {
                    val map = insights as? Map<String, Any> ?: return@let
                    map.mapKeys { (key, _) ->
                        key.split('_').joinToString("") { it.capitalize() }
                            .replaceFirstChar { it.lowercaseChar() }
                    }
                } else {
                    insights
                }
                CascadeEventBus.emit(MemoryEvent("kai_insight", normalizedInsights.toString()))
            } catch (e: Exception) {
                logger.e("GenesisBackedKaiAIService", "Error processing evolution insights", e)
            }
        }
    }
}
