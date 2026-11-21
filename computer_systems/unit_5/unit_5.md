# Unit 5: Using and Administering Windows 11

## Overview & Contents
- **General features:** a short history from MS-DOS to Windows 11, minimum requirements, licences, updates and apps.
- **Interface and configuration:** desktop, windows, taskbar, the **Settings** app, **Control Panel**, notifications and help.
- **Administration and file systems:** Task Manager, Disk Management, formatting, **FAT / exFAT / NTFS**, File Explorer.
- **User accounts:** account types, creating accounts, lock screen and sign-in options (Windows Hello).
- **Command line interface (CLI):** why scripts still matter.

## Block 1: General Features
| Year | Milestone |
|---|---|
| 1981 | **MS-DOS** (MicroSoft Disk Operating System), Microsoft's first commercial OS |
| 1987 | **Windows 2.0**, first Microsoft OS with a graphical environment |
| 1990 | **Windows 3.0**, big success, 256-colour palette |
| 1995 | **Windows 95**, Internet Explorer built in; Windows becomes the most used PC OS |
| 2021 | **Windows 11**, friendlier and cleaner design, optimized to save resources and energy |

### Minimum requirements
Always check compatibility and minimum requirements before installing an OS. Windows 11 no longer has a 32-bit version.

| Component | Requirement |
|---|---|
| Processor | 1 GHz or faster, 2+ cores, compatible 64-bit CPU or SoC |
| TPM | Trusted Platform Module **2.0** |
| Memory | 4 GB RAM |
| Graphics | DirectX 12 / WDDM 2.x compatible |
| Storage | 64 GB or more |
| Display | > 9" with HD (720p) resolution |
| System firmware | **UEFI** with **Secure Boot** |
| Internet | Windows 11 Home needs a Microsoft account and Internet connection |

### Licences
Windows is **proprietary software**: protected by copyright, so it can't be modified, distributed or copied. Using it means accepting the **EULA** (End User License Agreement), in Spanish **CLUF**. Editions: Home, Pro, Education and Enterprise.

Product key format: `XXXXX-XXXXX-XXXXX-XXXXX-XXXXX` (five blocks of five characters). Virtualized installs need a licence or key per instance.

| Licence | Conditions |
|---|---|
| **OEM** | Key sent by email, available in under 24 h. Tied to one machine |
| **OEM COA** | Key on a sticker with an authenticity hologram, shipped in 48-72 h |
| **OEM BOX** | Sticker with hologram plus installation DVD, 48-72 h |
| **RETAIL** | Sticker, hologram and DVD. The most permissive: install and activate on any compatible machine, just not on two at the same time. When you change hardware, deactivate and reactivate |

Activation: **Control Panel > System and Security > System** and enter the key.

### Updates and apps
- **Updates** are fixes (patches), improvements or extensions of the system and its bundled apps. Keeping the OS updated is basic security. They are managed from **Settings > Windows Update**: check for updates, optional updates, automatic install on/off, recommended updates and updates for other Microsoft products (e.g. Office).
- **Microsoft Store** is the official place to install apps (similar to Google Play or the App Store). It exists so users don't download apps modified with **malware** from fake sites. Windows also has the **Windows Subsystem for Linux** and the Windows Subsystem for Android.
- Right-click options on an app: **Pin/Unpin from Start**, **Pin/Unpin from taskbar**, **Open file location**, **Run as administrator** (typical for CMD or PowerShell).
- Store apps are optimized for touch, have no classic menus (options are in the context menu), are reviewed by Microsoft, and can be installed on up to **five devices** with one purchase.

## Block 2: Interface and Configuration
Windows 11 has a minimalist design: simpler menus, no live tiles and no Cortana, better multitasking, a new **Widgets** menu and as many **virtual desktops** as you need. The **Start menu** now sits in the centre of the taskbar and gathers recent apps, documents (local or cloud), search and settings.

### Types of windows
| Window | What it shows |
|---|---|
| Document window | The app tied to the file extension (e.g. `.docx` → Word) |
| File Explorer | Manage local and remote folders and files |
| Settings window | Change system features (main one: Control Panel) |
| Console | **CMD** (MS-DOS commands) and **PowerShell** |

### Taskbar
Centred by default (it can be moved back to the left). Pinned by default: Start, Search, Task View (virtual desktops), Widgets, File Explorer and Store. Two zones: **apps** (centre) and **notification area** (right).

### Settings app (12 categories + Gaming)
| Category | What you configure |
|---|---|
| System | Display, sound, notifications, focus, power and battery, storage |
| Bluetooth & devices | Add or remove peripherals; Windows looks for drivers automatically |
| Phone | Connection with your mobile |
| Network & Internet | Wi-Fi, 3G/4G/5G, airplane mode |
| Personalization | Lock screen, start screen, themes |
| Apps | App options, permissions, uninstall |
| Accounts | Add users, change account settings |
| Time & language | Time zone, daylight saving, language preferences |
| Accessibility | High contrast, larger cursor, longer notifications |
| Search | Search files, permissions... |
| Privacy & security | App access to personal data, **Windows Defender** |
| Windows Update | Updates, Windows Insider programme |
| Gaming | Gaming options |

### Control Panel (8 categories, inherited)
| Category | What you configure |
|---|---|
| System and Security | PC status, **File History**, backup and restore |
| Network and Internet | Network status and tasks |
| Hardware and Sound | Devices, printers, mobility settings |
| Programs | Uninstall classic programs |
| User Accounts | Account changes |
| Appearance and Personalization | Taskbar, navigation, File Explorer options, fonts |
| Clock and Region | Time, time zones, currency/region |
| Ease of Access | Accessibility centre, speech recognition |

Windows keeps **both** Settings and Control Panel for compatibility.

- **Notifications:** **Start > Settings > System > Notifications**. One switch per app; you can turn them all off, mute them or hide them on the lock screen.
- **Help:** press **F1** on the desktop (opens Edge/Bing with "Get help in Windows 11") or use the **Troubleshoot** tool.

## Block 3: Administration and File Systems
### Task Manager
Open it with right-click on the taskbar, **Ctrl + Shift + Esc** (direct) or **Ctrl + Alt + Del** (menu: lock, switch user, sign out, change password, Task Manager).

| Tab | What it shows |
|---|---|
| Processes | Running apps and the resources they use |
| Performance | CPU, memory, disks, network (also L1/L2/L3 cache) |
| App history | What has been used since a given date |
| Startup | Apps that run at boot |
| Users | Apps of the current user |
| Details | Name, **PID**, status, user (e.g. SYSTEM), CPU, memory, virtualization; **End task** |
| Services | System processes, running or stopped |

When an app shows "Not responding", ending it from Task Manager is faster, but **unsaved changes are lost**. If you want to keep your work, wait a few minutes for Windows to recover it.

### Disk Management
Changes are transparent to users and usually don't need a restart.

- Create partitions from a new volume (basic, extended, dynamic...).
- Convert disks (e.g. exFAT → NTFS).
- Extend or shrink volumes.

Formatting an external disk: choose volume size, file system, **allocation unit size** and **volume label**. Quick format deletes the content quickly. Use **NTFS or exFAT**: with FAT32 you can't copy files bigger than **4 GB**.

### File systems
| File system | Notes |
|---|---|
| **FAT** (16/32 bits) | Oldest and most basic, kept for compatibility |
| **exFAT** | Improved FAT, typical for USB drives and external disks |
| **NTFS** | Born with Windows NT, designed for networked systems, the most used today |
| **WinFS** | Newer, oriented to databases |
| HFS (macOS) / ext4 (Linux) | File systems of other OSs |

Default allocation unit size by volume:

| Volume size | NTFS | exFAT | FAT32 | FAT16 |
|---|---|---|---|---|
| 7 MB-256 MB | 4 KB | 4 KB | ½, 1 or 2 KB | ½, 1, 2 or 4 KB |
| 256 MB-4 GB | 4 KB | 32 KB | 4, 8 or 16 KB | 8-64 KB |
| 4 GB-32 GB | 4 KB | 32 KB | 4, 8 or 16 KB | Not supported |
| 32 GB-2 TB | 4 KB | 128 KB | 16/32 KB | Not supported |
| 2 TB-256 TB | 4-32 KB | 128 KB | Not supported | Not supported |
| > 256 TB | Not supported | Not supported | Not supported | Not supported |

### File Explorer
Ways to open it: **Windows + E**, right-click on Start, typing `explorer` in CMD or PowerShell, or pinning it to the taskbar. It gives access to local disks, network disks and **OneDrive**.

## Block 4: User Accounts
Accounts let several people share a device (or network resources) without interfering with each other: each user has their own Start screen, apps, folders and desktop.

| Account type | Permissions |
|---|---|
| **Standard** | Can change settings that don't affect other users or global security; can run installed programs |
| **Initial user** | Like standard, but can elevate to administrator for specific apps (e.g. consoles). Belongs to the Administrators group |
| **Administrator** | No restrictions: manage other users, security policies, installs |
| **Guest** | The most restricted: no installs, no system changes |

The built-in **Administrator** and **Guest** accounts are **disabled by default** for security.

Create an account: **Start > Settings > Accounts > Email & accounts > Add account**. You can use an existing Microsoft account, create one (and an Outlook address), or create a **local account** with "Sign in without a Microsoft account".

### Starting Windows
- **Lock screen:** first screen after boot, shows battery, network, unread mail, upcoming events. Customize it in **Settings > Personalization > Lock screen**.
- **Sign-in screen (Windows Hello):** validates your credentials. Windows 11 requires a Microsoft account (or a work/school Office 365 account), synced with Azure.

Sign-in options (**Settings > Accounts > Sign-in options**):

| Method | Notes |
|---|---|
| Password | Default option |
| PIN | 4 digits of your choice, quick like on a phone |
| Picture password | Three gestures (lines, circles, taps) on a picture |
| No password | Not recommended; only for test machines without important data |

## Block 5: Command Line Interface (CLI)
Ways of giving orders to a system have evolved: **CLI** (command line) → **GUI** (graphical user interface) → **NUI** (natural user interface: voice and gestures). The CLI was the first one and is still very useful for administrators and developers, because it lets you **automate routine and repetitive tasks with scripts**. In Windows the CLIs are **CMD** and **PowerShell**.

## Cheat Sheet
| Question | Answer |
|---|---|
| Firmware required by Windows 11 | UEFI + Secure Boot |
| Security chip required | TPM 2.0 |
| Most permissive licence | RETAIL |
| Licence agreement | EULA (CLUF in Spanish) |
| Open Task Manager directly | Ctrl + Shift + Esc |
| Open File Explorer | Windows + E |
| File system with 4 GB file limit | FAT32 |
| File system for USB drives | exFAT |
| Most used Windows file system | NTFS |
| Accounts disabled by default | Administrator and Guest |
| Open Windows help | F1 |
