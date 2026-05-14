![Kotlin](https://img.shields.io/badge/Kotlin-7F52FF?style=flat&logo=kotlin&logoColor=white)
![Android](https://img.shields.io/badge/Android-3DDC84?style=flat&logo=android&logoColor=white)
![Wear OS](https://img.shields.io/badge/Wear%20OS-4285F4?style=flat&logo=wearios&logoColor=white)
![ASP.NET Core](https://img.shields.io/badge/ASP.NET%20Core-512BD4?style=flat&logo=dotnet&logoColor=white)
![Azure](https://img.shields.io/badge/Azure-0078D4?style=flat&logo=microsoftazure&logoColor=white)
![Swagger](https://img.shields.io/badge/Swagger-85EA2D?style=flat&logo=swagger&logoColor=black)
![License: GPL v3](https://img.shields.io/badge/License-GPLv3-blue?style=flat)

# SmartMenza

SmartMenza is an Android application for a university smart canteen system, developed as a team project at the **Faculty of Organization and Informatics (FOI)** in collaboration with the company **Span**, following agile methodology (Scrum). Students can browse daily menus, track nutritional goals, manage favourite dishes, and leave reviews while canteen employees manage the menu with AI-powered tools.

This repository is a **portfolio copy** of the project originally hosted on Azure DevOps. It includes the complete team codebase along with a **Wear OS companion module**, an individual assignment implemented independently at the end of the semester, enabling real-time smartwatch display of daily canteen menus synchronized from the mobile app.

> Full project documentation (Wiki, user stories, architecture) is written in Croatian, as required by the university course specification.

---

## Context

| | |
|---|---|
| **Course** | Agile Mobile Application Development (JCC) |
| **Partner company** | Span |
| **Methodology** | Scrum (sprints, backlog, definition of done/ready) |
| **Team** | 5 members |
| **My role** | Backend developer (API, business logic, Swagger) + individual Wear OS assignment |

---

## Features

### Student
- Browse the daily canteen menu (lunch and dinner)
- View detailed dish information: ingredients, nutritional values, average rating
- Add, update and delete personal dietary goals: calories, proteins, fats, carbs
- Mark and manage favourite dishes
- Rate and comment on dishes and view reviews from other students

### Canteen employee
- Create, edit and delete daily menus and dishes
- Upload dish images
- AI-powered nutritional analysis of dish ingredients
- AI-powered dish image generation
- View usage statistics, most favourited and most reviewed dishes

### Wear OS (individual assignment)
- Display today's lunch and dinner on smartwatch
- Real-time data synchronization with the mobile app via Wearable Data Layer API
- Auto-refresh on app open, rotary scroll support
- Wear OS themed UI consistent with the main application
- No direct network calls from the watch, battery-efficient design

---

## Architecture

### System overview

```
Azure Backend (.NET 8) ──► Android App (Kotlin) ──► Data Layer API ──► Wear OS App
```

The mobile app fetches menu data from the live Azure-hosted REST API and forwards it to the Wear OS companion app through Google's Wearable Data Layer, avoiding direct network calls from the watch.

### Backend — Layered architecture

The backend follows a strict **multi-layered architecture** with SOLID principles, particularly the Dependency Inversion Principle:

| Layer | Project | Responsibility |
|---|---|---|
| API | `SmartMenza.API` | HTTP controllers, request handling, response mapping |
| Business | `SmartMenza.Business` | All business logic, services, JWT authentication, DTO mapping |
| Data | `SmartMenza.Data` | EF Core context, entity definitions, migrations, data seeding |
| Core | `SmartMenza.Core` | Shared enums, constants, no dependencies on other layers |

Controllers are kept clean, no business logic, all dependencies injected via DI:
```csharp
builder.Services.AddScoped<IUserService, UserServices>();
```

### Frontend — Modular architecture

The Android app uses a **modular architecture** for maintainability and reuse:

| Module | Location | Role |
|---|---|---|
| `app` | `/app` | Main module — UI, navigation, business logic, API calls |
| `core` | `/core` | Shared components, `SessionManager`, common abstractions |
| `mailauth` | `/mailauth` | Email/password registration and login flow |
| `googleauth` | `/googleauth` | Google OAuth authentication flow |
| `wear` | `/wear` | Wear OS companion — menu display, Data Layer sync |

---

## Tech Stack

| Layer | Technology |
|---|---|
| Mobile (Android) | Kotlin, Jetpack Compose, MVVM, Retrofit |
| Wear OS | Kotlin, Compose for Wear OS, Wearable Data Layer API |
| Backend | ASP.NET Core 8, Entity Framework Core, JWT |
| Database | SQL Server, Azure SQL |
| Authentication | Google OAuth, Email/Password (JWT) |
| AI integrations | Nutritional analysis API, Image generation API |
| DevOps | Azure DevOps, Azure App Service |
| Documentation | Swagger / OpenAPI |

---

## Running the Project

### Mobile app
1. Clone this repository
2. Open in Android Studio
3. Run the `app` configuration on an Android device or emulator (API 26+)

### Wear OS app
1. Open in Android Studio
2. Create a Wear OS emulator, **Wear OS Small Round** recommended
3. Run the `wear` configuration on the Wear emulator
4. Pair with a running mobile app instance for live data synchronization

### Backend
The backend is live and publicly accessible, no local setup required.

- **Swagger UI:** https://smartmenza-h5csfahadafnajaq.germanywestcentral-01.azurewebsites.net/swagger

Key endpoints:

```
GET  /api/DailyMenu/today
GET  /api/DailyMenu/today/grouped
GET  /api/DailyMenu/{yyyy-mm-dd}
GET  /api/Dish/{id}
GET  /api/User
POST /api/User/login
POST /api/User/register
POST /api/User/google-login
```

---

## Documentation

Project documentation is located in the [`docs/`](./docs/) folder, exported from the original Azure DevOps Wiki:

- [`Arhitektura-proizvoda-i-podsustava.md`](./docs/Arhitektura-proizvoda-i-podsustava.md) — Full system architecture (frontend modules, backend layers, SOLID principles)
- [`Funkcionalnosti-aplikacije-(epics,-korisničke-priče).md`](./docs/Funkcionalnosti-aplikacije-(epics,-korisni%C4%8Dke-pri%C4%8De).md) — Epics and user stories for all features
- [`Plan-iteracija.md`](./docs/Plan-iteracija.md) — Sprint plan and iteration breakdown
- [`attachments/`](./docs/attachments/) — Architecture diagrams, wireframes, and app screenshots

---

## Contributions

### Team contributions (JCC with Span)
- Backend API design and implementation (ASP.NET Core 8, Entity Framework Core)
- Layered architecture with SOLID principles (DIP, SRP, ISP)
- JWT authentication, email/password and Google OAuth
- REST API endpoints for menus, dishes, users, reviews, goals, and statistics
- AI integrations, nutritional analysis and dish image generation
- Azure deployment and DevOps pipeline setup
- Swagger / OpenAPI documentation
- Android mobile app UI/UX design and implementation
- Application wireframes and screen design

### Individual assignment (Wear OS module)
- Full Wear OS module implemented independently from scratch
- Phone-to-watch data synchronization via Wearable Data Layer API
- `WearDataService` and `WearDataListenerService` implementation
- Wear OS themed UI built with Compose for Wear OS
- Battery-efficient architecture, no direct API calls from the watch
- Debugging and resolving threading and data synchronization issues

---

## License

GPL-3.0 — see [LICENSE](LICENSE) for details.
