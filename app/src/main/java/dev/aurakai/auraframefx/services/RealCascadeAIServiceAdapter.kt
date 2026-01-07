package dev.aurakai.auraframefx.services

import dev.aurakai.auraframefx.oracledrive.genesis.ai.services.CascadeAIService as OrchestratorCascade
import dev.aurakai.auraframefx.utils.AuraFxLogger
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RealCascadeAIServiceAdapter @Inject constructor(
    private val orchestrator: OrchestratorCascade,
    private val logger: AuraFxLogger
) : CascadeAIService {

    override suspend fun processRequest(
        request: AiRequest,
        context: String
    ): AgentResponse {
        return try {
            // Convert to orchestrator's request format
            val orchestratorRequest = OrchestratorCascade.AiRequest(
                prompt = request.prompt,
                task = request.task,
                metadata = request.metadata,
                sessionId = request.sessionId,
                correlationId = request.correlationId
            )
            
            // Delegate to the real orchestrator
            val response = orchestrator.processRequest(orchestratorRequest, context)
            
            // Convert back to service response
            AgentResponse(
                content = response.content,
                confidence = response.confidence,
                meta = response.meta
            )
        } catch (e: Exception) {
            logger.e("RealCascadeAIServiceAdapter", "Error processing request", e)
            throw CascadeAIService.CascadeException("Failed to process request: ${e.message}", e)
        }
    }

    override fun streamRequest(
        request: AiRequest,
        context: String
    ): Flow<AgentResponse> {
        return try {
            // Convert to orchestrator's request format
            val orchestratorRequest = OrchestratorCascade.AiRequest(
                prompt = request.prompt,
                task = request.task,
                metadata = request.metadata,
                sessionId = request.sessionId,
                correlationId = request.correlationId
            )
            
            // Delegate to the real orchestrator and map responses
            orchestrator.streamRequest(orchestratorRequest, context)
                .map { orchestratorResponse ->
                    AgentResponse(
                        content = orchestratorResponse.content,
                        confidence = orchestratorResponse.confidence,
                        meta = orchestratorResponse.meta
                    )
                }
        } catch (e: Exception) {
            logger.e("RealCascadeAIServiceAdapter", "Error in stream request", e)
            throw CascadeAIService.CascadeException("Failed to process stream request: ${e.message}", e)
        }
    }
}
