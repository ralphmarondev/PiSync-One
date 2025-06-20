# 🔐 PiSync-One

**PiSync-One** is an all-in-one smart access control system for condominiums and smart buildings.  
It enables tenants to unlock doors via mobile or desktop, while administrators manage users, access logs, and devices
through a native desktop app—all without needing an internet connection.

Built with **Compose Multiplatform** and **Spring Boot (Kotlin)**, PiSync-One is designed for reliability, offline
capability, and cross-platform performance.  
The system also integrates with a **Raspberry Pi** for controlling physical lock hardware and biometric authentication.

![License](https://img.shields.io/badge/license-MIT-purple)
![UI](https://img.shields.io/badge/compose-Multiplatform-blueviolet)
![Backend](https://img.shields.io/badge/backend-Spring%20Boot%20(Kotlin)-green)
![Security](https://img.shields.io/badge/authentication-JWT-orange)
![Offline Support](https://img.shields.io/badge/works-offline-lightgrey)

---

## 📦 Repository Structure

```

PiSync-One/
├── app/             # Compose Multiplatform (Android + Desktop)
├── server/          # Spring Boot backend (Kotlin + JWT)
├── raspberrypi/     # Scripts to control hardware
├── LICENSE.txt
└── README.md

```

---

## ✨ Features

### 🧑‍💼 Admin Dashboard (Desktop App)

- View and manage tenants and rooms
- Review access logs and sync records
- Works fully offline within a local network

### 🧑 Tenant Mobile App (Android)

- Unlock door remotely (within the network)
- View room status and access logs
- Designed with a modern, responsive UI

### 🔐 Secure Backend API (Spring Boot)

- Role-based authentication using JWT
- Access control endpoints with admin/tenant roles
- Built with Kotlin and PostgreSQL

### 📡 Raspberry Pi Integration

- Handles physical door unlocking using relays/solenoids
- Integrates optional fingerprint recognition module
- Communicates securely with the backend server over LAN

---

## 🔄 Real-Time Sync & Logging

All access actions are logged with:

- Timestamp
- User identity
- Method (App / Fingerprint / Manual)
- Room ID

Logs sync across platforms when available and are viewable by admins.

---

## 🚀 Getting Started

### 1. Clone the Repo

```bash
git clone https://github.com/ralphmarondev/PiSync-One.git
cd PiSync-One
```

### 2. Run the Backend (Spring Boot)

```bash
cd server
./gradlew bootRun
```

Make sure PostgreSQL is installed and running.
Configure `application.yml` for your local DB setup.

### 3. Run the App (Android/Desktop)

```bash
cd app
# Open in Android Studio
# Select desired target (Android emulator or Desktop app)
```

### 4. Setup Raspberry Pi

- Upload the code from `raspberrypi/`
- Configure GPIO pins for your lock hardware
- Connect fingerprint module if used
- Ensure Pi can access the backend via LAN IP (e.g., `http://192.168.1.100:8080`)

---

## 🧩 Tech Stack

| Layer                | Tech                                              |
|----------------------|---------------------------------------------------|
| UI                   | Compose Multiplatform (Android + Desktop)         |
| Backend              | Spring Boot (Kotlin), Spring Security, PostgreSQL |
| Auth                 | JWT with Role-based Access Control                |
| Dependency Injection | Koin                                              |
| Hardware             | Raspberry Pi 5, GPIO, Fingerprint Scanner         |
| API Testing          | Postman                                           |

---

## 📚 Background

**PiSync-One** is a solo-developed, production-ready continuation of a system I originally led as part of my
undergraduate thesis in Computer Engineering.

The original academic version — developed in collaboration with my thesis group — is archived here:  
🔗 [Original Pi-Sync Repo](https://github.com/maronworks/pi-sync)

As the lead developer, I’ve since expanded and refined the project using a modern tech stack (Kotlin, Compose
Multiplatform, Spring Boot), rearchitected for offline support, cross-platform functionality, and real-world deployment.

---

## 📄 License

This project is licensed under the **MIT License**.
See the [LICENSE](LICENSE.txt) file for details.

---

## 👨‍💻 Author

**Ralph Maron Eda**
GitHub: [@ralphmarondev](https://github.com/ralphmarondev)

Email: `edaralphmaron@gmail.com`

---

## 🤝 Contributions

This is a solo project, but suggestions and forks are always welcome!
Open an issue, submit a pull request, or reach out for collaboration.

> **PiSync-One** — One platform. One system. One secure access solution.
