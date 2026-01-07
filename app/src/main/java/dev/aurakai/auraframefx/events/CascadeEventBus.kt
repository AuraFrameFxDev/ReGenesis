package dev.aurakai.auraframefx.events

import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Event bus for Cascade system events.
 */
@Singleton
class CascadeEventBus @Inject constructor() {
    private val _events = MutableSharedFlow<CascadeEvent>(extraBufferCapacity = 64)
    val events: SharedFlow<CascadeEvent> = _events

    fun emit(event: CascadeEvent) {
        _events.tryEmit(event)
    }

    // Compatibility method for error log "tryEmit is never used" - making it public usage
    fun tryEmit(event: CascadeEvent): Boolean {
        return _events.tryEmit(event)
    }
}

interface CascadeEvent

data class MemoryEvent(
    val type: String,
    val data: Map<String, Any>
) : CascadeEvent
