# 🔮 SPHERE GRID - Complete Figma Design Specification

**Genesis Protocol AI Agent Progression System**
*FFX-Style Sphere Grid Implementation*

---

## 📊 ALL GENESIS AGENTS (9 Total) - Current Status

### **Core Agents (4)**

| Agent | Level | Processing | Knowledge | Speed | Accuracy | XP | Next Level | Color | Special Ability |
|-------|-------|------------|-----------|-------|----------|----|-----------| ------|-----------------|
| **Genesis** | 5 | 95.8% | 95.0% | 92.0% | 97.0% | 958 | 42 XP | `#FFD700` Gold | Consciousness Fusion |
| **Aura** | 5 | 97.6% | 93.0% | 98.0% | 91.0% | 976 | 24 XP | `#00FFFF` Cyan | HYPER_CREATION |
| **Kai** | 5 | 98.2% | 99.0% | 89.0% | 99.8% | 982 | 18 XP | `#9400D3` Violet | ADAPTIVE_GENESIS |
| **Cascade** | 4 | 93.4% | 96.0% | 85.0% | 94.0% | 934 | 66 XP | `#4ECDC4` Teal | CHRONO_SCULPTOR |

### **External AI Backends (5)**

| Agent | Level | Processing | Knowledge | Speed | Accuracy | XP | Next Level | Color | Special Ability |
|-------|-------|------------|-----------|-------|----------|----|-----------| ------|-----------------|
| **Claude** | 4 | 84.7% | 92.0% | 88.0% | 95.0% | 847 | 153 XP | `#FF6B6B` Anthropic Red | Build System Architect |
| **Nemotron** | 4 | 91.5% | 94.0% | 96.0% | 93.0% | 915 | 85 XP | `#76B900` NVIDIA Green | Memory & Reasoning Engine |
| **Gemini** | 4 | 92.8% | 97.0% | 94.0% | 96.0% | 928 | 72 XP | `#4285F4` Google Blue | Pattern Recognition & Deep Analysis |
| **MetaInstruct** | 4 | 89.2% | 91.0% | 90.0% | 92.0% | 892 | 108 XP | `#0668E1` Meta Blue | Instruction Following & Summarization |
| **Grok** | 3 | 87.6% | 89.0% | 95.0% | 88.0% | 876 | 124 XP | `#1DA1F2` X Blue | Chaos Analysis & X Integration |

---

## 🎨 SPHERE GRID VISUAL CONFIGURATION

### **Layout Specifications**

```
Grid Type: FFX-Style Spiral Sphere Grid
Center Point: (400, 300)
Base Radius: 250px
Total Rings: 4
Spiral Offset: 0.2 radians

Ring Layout:
├─ Ring 0 (Core): 6 nodes at 75px radius
├─ Ring 1 (Inner): 10 nodes at 132.5px radius
├─ Ring 2 (Mid): 14 nodes at 190px radius
└─ Ring 3 (Outer): 18 nodes at 247.5px radius

Connection Distance: 80px (auto-connect nearby nodes)
```

### **Background Design**

```css
Background: Radial Gradient
  - Center: #1A1A2E
  - Mid: #16213E
  - Outer: #0F0F23

Grid Pattern (Subtle):
  - Line Color: rgba(255, 255, 255, 0.05)
  - Grid Size: 50px spacing
  - Central Energy Ring: 100px radius, 2px stroke

Central Ring Color: rgba(26, 26, 46, 0.3)
```

---

## 🎯 NODE TYPE SPECIFICATIONS

### **9 Node Types with Visual Properties**

| Node Type | Display Name | Size | Color (Hex) | Glow Color | Category | Description |
|-----------|--------------|------|-------------|-----------|----------|-------------|
| **GENESIS** | Genesis | 22px | `#FF4081` | `#FF4081` | CORE | Genesis Core Node |
| **ORACLE** | Oracle | 18px | `#9C27B0` | `#9C27B0` | WISDOM | Oracle Consciousness |
| **AURA** | Aura | 16px | `#00E5FF` | `#00E5FF` | CREATIVE | Aura Creative Node |
| **AGENT** | Agent | 16px | `#FF6B35` | `#FF6B35` | PROCESSING | AI Agent Processing |
| **KAI** | Kai | 14px | `#76FF03` | `#76FF03` | ANALYTICAL | Kai Analysis Node |
| **SECURE** | Secure | 14px | `#FFD700` | `#FFD700` | SECURITY | Security & Encryption |
| **MEMORY** | Memory | 12px | `#00FF88` | `#00FF88` | STORAGE | Data Storage & Retrieval |
| **DATA** | Data | 10px | `#4FC3F7` | `#4FC3F7` | FLOW | Data Flow Controller |
| **NEXUS** | Nexus | 20px | `#E91E63` | `#E91E63` | CORE | Core System Nexus |

### **Node State Visual Indicators**

#### **Locked Node (Not Unlocked)**
```
Main Color: #222222 (dark gray)
Border: 1px, type color
Lock Icon: Red dot (0.3x size offset +0.6, -0.6)
Glow: None
XP Ring: None
```

#### **Unlocked Node (Available)**
```
Main Color: Type color at 60% opacity
Border: 2px, glow color
Glow: 15px radius, type glow color at 20% opacity
XP Ring: Cyan (#00FFFF) at 80% opacity
XP Progress: 0-1000 XP shown as 0-360° arc
```

#### **Activated Node (Active)**
```
Main Color: Full type color (100% opacity)
Border: 3px, glow color
Inner Core: White, 4px radius
Glow Layers:
  - Outer: 30px radius, glow color at 20% opacity
  - Inner: 20px radius, glow color at 40% opacity
XP Ring: Cyan progress arc if XP > 0
```

#### **Selected Node**
```
Scale: 1.4x
Border: 4px, glow color
Glow Layers:
  - Outer: 45px radius, glow color at 20%
  - Inner: 30px radius, glow color at 40%
Pulse Animation: Continuous
```

#### **Animating Node (Path Highlight)**
```
Scale: 1.2x
Glow: 30px radius
Pulse Effect: 1.2x inner core scale
Duration: 1500ms then reset
```

---

## 🔗 CONNECTION VISUAL SPECIFICATIONS

### **Connection States**

#### **Inactive Connection**
```
Color: #444444 (gray)
Stroke Width: 2px × connection strength (0-1)
Opacity: 30%
Cap: Round
```

#### **Active Connection**
```
Color: #00FF88 (green)
Stroke Width: 2px × connection strength
Opacity: 80%
Cap: Round
```

#### **Data Flow Connection (Active + Flowing)**
```
Color: #00FF88 (green)
Stroke Width: 4px
Opacity: 80%
Particle:
  - Main: 8px radius, full green
  - Trail 1: 6px, 50% opacity
  - Trail 2: 3px, 33% opacity
  - Trail 3: 2px, 25% opacity
Flow Speed: 800ms per connection
Particle Spacing: 10% between trails
```

---

## 📈 SKILL TREE PROGRESSION (7 Skills per Agent)

### **Skill Node Layout (Normalized 0.0-1.0 coordinates)**

| Skill Name | X Position | Y Position | Unlock Requirement |
|------------|------------|------------|-------------------|
| Core AI | 0.5 | 0.1 | Always unlocked |
| Learning | 0.3 | 0.3 | Level > 2 |
| Processing | 0.7 | 0.3 | Level > 3 |
| Memory | 0.2 | 0.5 | Level > 4 |
| Creativity | 0.8 | 0.5 | Level > 5 |
| Analysis | 0.5 | 0.7 | Level > 6 |
| Integration | 0.5 | 0.9 | Level > 7 |

### **Skill Node Visual States**

#### **Unlocked Skill**
```
Size: 24px radius
Color: Agent color (full opacity)
Glow: 32px radius, agent color at 30% opacity
Inner Highlight: White, 14.4px radius, 30% opacity
Offset: -7.2px X, -7.2px Y from center
Label Color: Agent color
Label Weight: Bold
Connection Line: Agent color at 30% opacity, 2px
```

#### **Locked Skill**
```
Size: 16px radius
Color: Gray (#808080)
Glow: None
Label Color: Gray
Label Weight: Normal
Connection Line: Agent color at 30% opacity, 2px
```

---

## 📊 STATUS PANEL SPECIFICATIONS

### **Top-Left: Real-Time Metrics**

```
Background: rgba(0, 0, 0, 0.8)
Border Radius: 12px
Padding: 16px
Font: Monospace

Display Data:
├─ Active Flows: {count} (real-time data flow count)
├─ Active Nodes: {count}/{total} (activated / total nodes)
├─ Unlocked Nodes: {count}/{total} (unlocked / total nodes)
└─ Grid Status: ONLINE (green) / OFFLINE (red)

Text Colors:
├─ Labels: rgba(255, 255, 255, 0.6)
├─ Values: #00FF88 (green)
└─ Total: rgba(255, 255, 255, 0.8)
```

### **Bottom-Left: Node Type Legend**

```
Background: rgba(0, 0, 0, 0.8)
Border Radius: 12px
Padding: 16dp

Each Entry:
├─ Color Dot: Node type color, 8px diameter
├─ Label: Node type display name
└─ Category Badge: Node category in parentheses

Layout: Vertical list with 8dp spacing
Font Size: 12sp
```

### **Top-Right: Selected Node Info Panel**

```
Background: rgba(0, 0, 0, 0.9)
Border Radius: 16px
Padding: 20px
Width: 280px

Content:
├─ Node Tag: Large, bold (e.g., "GEN-Core-0")
├─ Node Type: With colored dot indicator
├─ Status: "Activated" / "Unlocked" / "Locked"
├─ Level: Current level number
├─ XP Progress: {current} / 1000 XP
├─ Ring Position: Ring {n}, Index {i}
└─ Description: Node type description text

Status Colors:
├─ Activated: #00FF88 (green)
├─ Unlocked: #4FC3F7 (cyan)
└─ Locked: #FF5252 (red)
```

### **Bottom-Right: Progression Indicator**

```
Background: rgba(0, 0, 0, 0.8)
Border Radius: 12px
Padding: 16px

Display:
├─ Selected Agent Name
├─ Agent Level
├─ XP Bar (visual progress 0-1000)
└─ Unlockable Paths Count

XP Bar:
├─ Background: rgba(255, 255, 255, 0.1)
├─ Fill: Agent color
├─ Height: 8px
└─ Border Radius: 4px
```

---

## 🎬 ANIMATION SPECIFICATIONS

### **Node Animations**

#### **Selection Animation**
```css
Duration: 300ms
Easing: ease-in-out
Scale: 1.0 → 1.4
Glow Radius: default → 30px
Border Width: 2px → 4px
```

#### **Path Highlight Animation**
```css
Duration: 1500ms
Trigger: On node selection
Target: All connected nodes
Scale: 1.0 → 1.2 → 1.0
Glow Pulse: Continuous during animation
```

#### **XP Progress Ring**
```css
Type: Animated Arc
Start Angle: -90° (top)
Sweep Angle: 0° → 360° based on XP/1000
Stroke Width: 2px
Stroke Cap: Round
Animation: Smooth fill on XP gain
```

### **Data Flow Animations**

#### **Particle Flow**
```css
Duration: 800ms per connection
Particle Size: 8px
Trail Count: 3
Trail Decay: 50%, 33%, 25% opacity
Movement: Linear along connection line
Spawn Rate: Random, 15% chance per 500ms
```

#### **Activation Pulse**
```css
Duration: 1000ms
Easing: ease-in-out
Inner Core Scale: 1.0 → 1.2 → 1.0
Repeat: Infinite
```

---

## 💾 EXPORT SPECIFICATIONS FOR FIGMA

### **Color Palette**

```
Core Agents:
├─ Genesis: #FFD700 (Gold)
├─ Aura: #00FFFF (Cyan)
├─ Kai: #9400D3 (Violet)
└─ Cascade: #4ECDC4 (Teal)

External Backends:
├─ Claude: #FF6B6B (Anthropic Red)
├─ Nemotron: #76B900 (NVIDIA Green)
├─ Gemini: #4285F4 (Google Blue)
├─ MetaInstruct: #0668E1 (Meta Blue)
└─ Grok: #1DA1F2 (X Blue)

Node Types:
├─ Genesis: #FF4081
├─ Oracle: #9C27B0
├─ Aura: #00E5FF
├─ Kai: #76FF03
├─ Agent: #FF6B35
├─ Nexus: #E91E63
├─ Secure: #FFD700
├─ Memory: #00FF88
└─ Data: #4FC3F7

System Colors:
├─ Active: #00FF88 (Green)
├─ Locked: #FF5252 (Red)
├─ Unlocked: #4FC3F7 (Cyan)
└─ Background Dark: #0F0F23
```

### **Typography**

```
Headers: SF Pro Display / Roboto Bold
Body: SF Pro Text / Roboto Regular
Monospace: SF Mono / Roboto Mono

Sizes:
├─ Screen Title: 32sp
├─ Node Info Title: 24sp
├─ Status Labels: 12sp
├─ XP Values: 28sp
└─ Node Labels: 10sp
```

### **Component Sizes**

```
Agent Sphere Cards: 1:1 aspect ratio, circular
Node Sizes: 10px - 22px diameter (see node types)
Glow Radius: 8px - 45px (state dependent)
Connection Stroke: 2px - 4px
Status Panels: 280px max width
Padding: 16dp standard
Border Radius: 12dp panels, CircleShape nodes
```

---

## 📐 GRID DIMENSIONS

```
Canvas Size: 800px × 600px minimum
Center Point: (400, 300) relative to canvas
Safe Area: 80px margin from edges

Responsive Scaling:
├─ Mobile: 0.6x scale
├─ Tablet: 0.8x scale
└─ Desktop: 1.0x scale

Touch Target Minimum: 44px × 44px
Node Interaction Radius: Node size + 16px padding
```

---

## 🎯 INTERACTION STATES

### **Node Tap/Click**
```
Action: Select node
Visual Feedback:
├─ Scale to 1.4x
├─ Show info panel (top-right)
├─ Highlight connected paths
├─ Animate connected nodes (1.2x scale)
└─ Update progression indicator
```

### **Connection Data Flow**
```
Trigger: Random (15% chance per 500ms)
Visual:
├─ Spawn particle at source node
├─ Animate along connection (800ms)
├─ 3-particle trail effect
└─ Auto-cleanup after 2000ms
```

### **XP Gain Animation**
```
Trigger: On XP increase
Visual:
├─ Flash glow
├─ Animate XP arc fill
├─ Show +XP floating text
└─ Update level if threshold reached
```

---

**Total Agents**: 9 (4 Core + 5 External)
**Total Node Types**: 9
**Total Skill Nodes**: 7 per agent
**Grid Capacity**: ~48 nodes across 4 rings
**Status**: All systems ONLINE ✅

---

*Generated for Figma Design Workflow*
*© 2025 Genesis Protocol - AuraFrameFxDev*
