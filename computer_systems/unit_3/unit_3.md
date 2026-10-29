# Unit 3: Hardware, Assembly, and Safety Measures

## Overview & Contents
- **Key Topic 1: Cases, Power Supplies, and Cooling:** Overview of physical computer components, form factors, power conversion stages, and cooling methods (air, liquid, mixed).
- **Key Topic 2: Occupational Risk Prevention (PRL) & Safety Norms:** Workplace safety regulations, environmental conditions, ergonomic guidelines, electrical safety, fire protection, and mandatory safety signage.
- **Key Topic 3: Workshop Rules, Tools & Assembly Sequence:** Best practices for PC building (ESD protection, cable/component organization), necessary tools, step-by-step assembly procedure, and critical assembly precautions.
- **Key Topic 4: Booting & Maintenance:** Types of maintenance (preventive, predictive, corrective), hardware/software diagnostic tools, and common troubleshooting steps using the KISS principle.
- **Practical Examples & Common Pitfalls:** Pin damage during CPU placement, improper thermal paste application, RAM orientation/dual-channel issues, and basic cable connection oversights.

## Cases, Power Supplies, and Cooling

Computer cases provide structural protection and organization for internal hardware components. They are typically constructed from steel, aluminum, or plastic, and contain external connectors, power buttons, and ventilation systems.

- Core structural elements:
  - **Chasis:** Internal metal framework where the motherboard and components are anchored.
  - **Cover:** Outer shell of the case.
  - **Front Panel:** Contains power/reset buttons, status LEDs, audio jacks, and USB ports.
  - **Drive Bays:** Slots located at the front for housing storage drives and optical media.
  - **Ventilation System:** Combination of fan mounts, air vents, and dust filters.

<img width="1024" height="644" alt="image" src="https://github.com/user-attachments/assets/02032e5c-1328-4562-a547-5a589c2b8c37" />

### Case Form Factors
| Form Factor | Description | Typical Use Case |
|---|---|---|
| **ATX / Mid Tower (Semitorre)** | Standard vertical case layout | Desktop PCs, mainstream builds |
| **Full Tower (Gran Torre)** | Large vertical case with extra expansion | High-end workstations, servers |
| **Mini-ITX / Slim / Cube** | Compact form factors for space saving | Small form factor (SFF) builds |
| **HTPC** | Home Theatre PC enclosure | Living room media centers |

### Power Supplies (PSU)

The power supply unit converts alternating current (**AC**) from the wall outlet into direct current (**CC**) required by internal components.

- Standard form factors:
  - **ATX:** $150 \times 86 \times 140\text{ mm}$, standard desktop power delivery ($300\text{ W} - 2000\text{ W}$).
  - **SFX:** Compact power supply for Mini-ITX cases.
  - **EPS:** Server-grade power supply standard.
- Core functions:
  - **Current Conversion:** Converts AC to CC.
  - **Power Distribution:** Provides designated voltage rails to components.
  - **Electrical Protection:** Guards against overvoltage, short circuits, and overheating.
  - **PFC (Power Factor Correction):** Active PFC achieves near $99\%$ power efficiency.
- Voltage output allocation:
  - **+12V Rail:** Supplies CPU, GPU, storage drives, and cooling fans.
  - **+5V Rail:** Power for USB ports and minor ICs.
  - **+3.3V Rail:** Powers RAM, motherboard chipsets, and expansion cards.
- Conversion stages:
  1. **Transform:** Reduces incoming AC voltage.
  2. **Rectify:** Converts AC to dual-wave CC using diodes.
  3. **Filter:** Smooths out the electrical signal using capacitors.
  4. **Stabilize:** Regulates output voltage for steady power delivery.
- Vital power connectors:
  - **20/24-pin ATX:** Primary power connector for the motherboard.
  - **4/8-pin EPS:** Dedicated clean power delivery for the CPU.

<img width="470" height="402" alt="image" src="https://github.com/user-attachments/assets/eefe5e90-85e1-474c-951a-477fff7e69a4" />

### Cooling Systems

Thermal management prevents overheating, stops automatic safety shutdowns, avoids **thermal throttling** (performance degradation due to excessive heat), and extends hardware lifespan.

| Cooling Type | Mechanism | Characteristics |
|---|---|---|
| **Air Cooling (Passive/Active)** | Heatsink absorbs heat; fans dissipate heat into the air across fins. | Cost-effective, simple maintenance, standard deployment. |
| **Liquid Cooling (AIO/Custom)** | Closed loop with coolant liquid, pump, tubing, and external radiator. | High thermal conductivity, ideal for overclocking and high TDP. |
| **Mixed Cooling** | Combination of liquid cooling for critical nodes (CPU) and air cooling for peripheral components (GPU/VRMs). | Balanced thermal management for targeted components. |

<img width="568" height="374" alt="image" src="https://github.com/user-attachments/assets/3e0edcd6-fc7d-4140-b9c1-07652745d1d0" />

---

## Occupational Risk Prevention (PRL) & Safety Regulations

Occupational safety regulations dictate rights and responsibilities designed to eliminate workplace accidents and reduce health hazards.

- Physical workplace hazards:
  - **Falls, Impacts, and Cuts:** Maintain clean, ordered work areas. Keep walkways clear, organize trailing cables, use non-slip flooring, and store cutting tools safely. Tools must feature **CE Marking**.
  - **Crush Hazards:** Anchor tall cabinets and file racks to walls. Use single-drawer opening safety mechanisms.
- Environmental and ergonomic requirements:
  - **Temperature:** Maintain between $17^\circ\text{C}$ and $27^\circ\text{C}$.
  - **Relative Humidity:** Maintain between $30\%$ and $70\%$.
  - **Lighting & Noise:** Position light sources parallel to screens to limit glare. Keep ambient noise levels below $50\text{ dB(A)}$.
  - **Rest Breaks:** Change posture and take short breaks regularly; avoid remaining seated continuously for over 2 hours.
  - **Ergonomics:** Position monitor $\sim 40\text{ cm}$ away with top edge at eye level. Use matte keyboards and contoured mice keeping wrists straight and elbows at $90^\circ$. Use an adjustable ergonomic chair and footrest if required.
- Electrical & fire safety:
  - **Electrical Systems:** Use dedicated circuit breakers (**magnetotérmicos**), differential switches, and grounded lines inside locked enclosures. Avoid outlet splitters to prevent overloads.
  - **Voltage Regulators:** Filter electrical signals to suppress voltage spikes.
  - **Fire Protection:** Maintain clear evacuation routes, functional fire detectors, alarms, hose reels, and inspected fire extinguishers.
- Safety signage classifications:
  - **Warning Signs (Yellow Triangle):** Electrical hazard, flammable materials, toxic substances, general danger.
  - **Prohibition Signs (Red Circle with Diagonal Bar):** No smoking, no open flames, pedestrian entry prohibited, no mobile phone usage.
  - **Mandatory Signs (Blue Circle):** Eye protection mandatory, head protection mandatory, safety gloves mandatory, foot protection mandatory.
  - **Emergency / Rescue Signs (Green Rectangle/Square):** First aid station, emergency exit, safety shower, eyewash station.

---

## Workshop Setup & Assembly Sequence

Assembling a personal computer requires static control, structured component tracking, and appropriate tooling.

- Assembly core rules:
  - **ESD (Electrostatic Discharge) Safety:** Always wear anti-static wrist straps to prevent invisible static discharges from damaging sensitive micro-transistors.
  - **Total Disconnection:** Never work inside the chassis while the power supply is connected to an active AC wall socket.
  - **Organized Workspace:** Use segmented magnetic parts trays to store screws and prevent stray metal parts from shorting the motherboard.
  - **Proper Lifting Technique:** Use safe lifting practices when moving heavy full-tower cases and server enclosures.
- Essential tools & supplies:
  - Magnetic Phillips screwdriver (ensure correct sizing to prevent stripping screw heads).
  - Fine tweezers, magnifying glass, zip ties, and side-cutter pliers.
  - Cleaning supplies: compressed air canister, variable hand vacuum, isopropyl alcohol, soft brushes, and cotton swabs.
  - Thermal calculation: Calculate total thermal power consumption (**TDP** = CPU + GPU + Drives) to select a PSU with headroom.

### Step-by-Step Assembly Procedure 
1. External Module Setup (Motherboard Prep)
2. Install CPU ➔ Apply Thermal Paste ➔ Mount CPU Cooler ➔ Insert RAM Modules
3. Internal Module Setup (Chassis Prep)
4. Mount PSU in Case ➔ Secure Storage Drives (SSD/HDD) into Bays
5. Integration Phase
6. Mount Motherboard into Chassis using Metal Standoffs
7. Expansion Phase
8. Install Dedicated Graphics Card (GPU) into PCIe x16 Slot
9. Wiring & Cabling
10. Route and Connect Power Cables (24-pin ATX, 8-pin EPS) & Front Panel I/O

- Assembly steps explained:
  1. **Chassis & Standoffs:** Install brass/metal standoffs into the chassis tray to prevent direct electrical contact between the motherboard back panel and the metal case.
  2. **CPU Installation:** Unlatch CPU socket lever (LGA or PGA). Align CPU using orientation triangles/notches without touching pins. Close retention lever and apply thermal paste.
  3. **RAM Installation:** Open side retention clips of DDR slots. Line up key notch on the memory stick and press straight down until clips lock into place with an audible click.
  4. **Cooler Mounting:** Secure heatsink/fan unit over CPU and paste. Plug fan power wire into motherboard `CPU_FAN` header.
  5. **Storage:** Install M.2 NVMe SSD into PCIe slot or mount 2.5"/3.5" SSD/HDD into drive bays. Connect SATA data lines to motherboard.
  6. **Front Panel Headers:** Connect `POWER SW`, `RESET SW`, `POWER LED`, `HDD LED`, USB, and HD Audio leads following motherboard pin diagram.
  7. **GPU Installation:** Remove expansion slot covers. Insert graphics card into top PCIe x16 slot, secure with chassis screws, and connect dedicated PCIe power cables.
  8. **Power Supply Cabling:** Connect 24-pin EATX main connector, 4/8-pin EPS CPU cable, and SATA power connectors.
  9. **Open Bench Test:** Verify fan rotation, LED activity, and display output before closing outer panel.

### Critical Considerations
- **CPU Socket Care:** Handle PGA pins gently. Avoid contacting internal pins in LGA motherboard sockets.
- **Thermal Paste Application:** Apply a small pea-sized amount in the center. Its sole function is filling microscopic surface gaps to maximize heat transfer, not adhesion.
- **RAM Dual Channel:** Follow motherboard manual slot pairings to enable dual-channel memory bandwidth.

---

## Maintenance & Troubleshooting

### Maintenance Types

| Type | Frequency | Core Actions | Primary Objective |
|---|---|---|---|
| **Preventive** | Semi-annual | Internal cleaning, thermal paste replacement, hardware check, system backups. | Proactively prevent hardware failures. |
| **Predictive** | Continuous / Weekly | Thermal tracking, drive S.M.A.R.T. telemetry monitoring, active malware scans. | Identify performance degradation trends before failure. |
| **Corrective** | On Failure | Replacing broken or malfunctioning hardware components. | Restore non-functional hardware to operation. |

### Diagnostic Tools
- **Hardware Tools:** ATX power supply voltage testers, RJ-45 network cable testers, hardware firewalls, backup servers.
- **Software Diagnostic & Benchmarking:** HWInfo, AIDA64, UserBenchmark, Open Hardware Monitor.
- **Enterprise Management:** Microsoft SCOM/SCCM, Goverlan, Nagios.
- **Help Desk Ticketing:** Jira Service Management, Zendesk, Freshdesk.

### Common Faults & KISS Troubleshooting Strategy
The **KISS Principle** (*Keep It Simple, Stupid!*) dictates checking the simplest potential fault points before diagnosing complex component failures.

| Symptom | KISS Check | Recommended Action |
|---|---|---|
| **System or display does not power on** | Is system plugged in? Did breaker trip? Is PSU power switch set to ON? | Re-seat power cables, reset main breaker, or bypass faulty UPS unit. |
| **No display output on monitor** | Is display cable (HDMI/DP) connected on both ends? Is monitor powered on? | Secure cable connections or test display on alternate system to isolate fault. |
| **Keyboard or mouse unresponsive** | Is device wired or wireless? Is USB receiver firmly connected? | Switch USB ports or replace wireless peripheral batteries. |
| **Front panel HDD LED unlit** | Is front panel LED wire attached properly? Is SATA power cable connected? | Check polarities of `HDD LED` pins on front panel header. |

---

## Code Examples

```bash
# Diagnostic command-line utilities for checking system hardware state (Linux)

# Display CPU details and architecture
lscpu

# Display detailed memory status
free -h

# Check drive S.M.A.R.T. status and health
sudo smartctl -a /dev/sda

# Monitor system thermals and fan speeds in real time
sensors
