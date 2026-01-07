package dev.aurakai.auraframefx

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.gestures.detectHorizontalDragGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import dev.aurakai.auraframefx.navigation.AppNavGraph
import dev.aurakai.auraframefx.navigation.GenesisNavigationHost
import dev.aurakai.auraframefx.navigation.GenesisRoutes
import dev.aurakai.auraframefx.ui.overlays.AgentSidebarMenu
import dev.aurakai.auraframefx.ui.overlays.AuraPresenceOverlay
import dev.aurakai.auraframefx.ui.overlays.ChatBubbleMenu
import dev.aurakai.auraframefx.ui.theme.AuraFrameFXTheme
import dev.aurakai.auraframefx.ui.theme.ThemeViewModel

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AuraFrameFXTheme {
                val themeViewModel: ThemeViewModel = hiltViewModel()
                MainScreen(themeViewModel = themeViewModel)
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        // Perform any cleanup here if needed
    }
}

// New: a preview-friendly content composable that accepts a lambda for theme commands
@OptIn(ExperimentalMaterial3Api::class)
/**
 * Hosts the app's navigation graph in a full-screen container that can optionally apply the digital pixel effect.
 *
 * @param processThemeCommand Callback invoked to process theme-related commands; receives the command as a `String`.
 */
@Composable
internal fun MainScreenContent(
    processThemeCommand: (String) -> Unit
) {
    val navController = rememberNavController()

    var showDigitalEffects by remember { mutableStateOf(true) }
    var command by remember { mutableStateOf("") }
    
    // Overlay state management
    var showSidebar by remember { mutableStateOf(false) }
    var showChatBubble by remember { mutableStateOf(true) }
    val density = LocalDensity.current

    Box(
        modifier = Modifier
            .fillMaxSize()
            .let { base ->
                if (showDigitalEffects) {
                    base.digitalPixelEffect()
                } else {
                    base
                }
            }
    ) {
        // Main navigation content
        GenesisNavigationHost(navController = navController)
        
        // Edge trigger zone for sidebar (left edge swipe)
        Box(
            modifier = Modifier
                .fillMaxSize()
                .zIndex(999f)
                .pointerInput(Unit) {
                    detectHorizontalDragGestures(
                        onDragStart = { offset ->
                            // If drag starts from left edge (within 30dp), open sidebar
                            if (offset.x < with(density) { 30.dp.toPx() }) {
                                showSidebar = true
                            }
                        }
                    )
                }
        )
        
        // Overlay system - Always present, system-wide
        Box(modifier = Modifier.fillMaxSize().zIndex(1000f)) {
            // Aura Presence Overlay - Always visible, bottom-right
            Box(
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .zIndex(1001f)
            ) {
                AuraPresenceOverlay(
                    onSuggestClicked = { suggestion ->
                        // Navigate to relevant screen based on suggestion
                        when {
                            suggestion.contains("theme") -> navController.navigate(GenesisRoutes.THEME_ENGINE)
                            suggestion.contains("firewall") -> navController.navigate(GenesisRoutes.FIREWALL)
                            suggestion.contains("canvas") -> navController.navigate(GenesisRoutes.COLLAB_CANVAS)
                            else -> navController.navigate(GenesisRoutes.DIRECT_CHAT)
                        }
                    }
                )
            }
            
            // Chat Bubble Menu - Floating, draggable
            if (showChatBubble) {
                Box(
                    modifier = Modifier
                        .align(Alignment.BottomStart)
                        .padding(16.dp)
                        .zIndex(1002f)
                ) {
                    ChatBubbleMenu(
                        onOpenChat = {
                            navController.navigate(GenesisRoutes.DIRECT_CHAT)
                        },
                        onToggleVoice = {
                            // TODO: Implement voice toggle
                        }
                    )
                }
            }
            
            // Agent Sidebar Menu - Slide out from left
            AgentSidebarMenu(
                isVisible = showSidebar,
                onDismiss = { showSidebar = false },
                onAgentAction = { agentName, action ->
                    when (action) {
                        "voice" -> navController.navigate(GenesisRoutes.DIRECT_CHAT)
                        "connect" -> navController.navigate(GenesisRoutes.CONFERENCE_ROOM)
                        "assign" -> navController.navigate(GenesisRoutes.TASK_ASSIGNMENT)
                        "design" -> navController.navigate(GenesisRoutes.AURAS_LAB)
                        "create" -> navController.navigate(GenesisRoutes.APP_BUILDER)
                        else -> {}
                    }
                    showSidebar = false
                }
            )
        }
    }
}

// Keep original API used by Activity: delegate to the content with the real ViewModel
@Composable
internal fun MainScreen(
    themeViewModel: ThemeViewModel
) {
    MainScreenContent(processThemeCommand = { themeViewModel.processThemeCommand(it) })
}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    AuraFrameFXTheme {
        // For preview, use a no-op lambda for the theme command handler
        MainScreenContent(processThemeCommand = { /* no-op in preview */ })
    }
}

// Extension function placeholder - this should be implemented elsewhere
fun Modifier.digitalPixelEffect(): Modifier = this