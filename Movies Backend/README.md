# Movies Backend

A Spring Boot REST API application for managing movies data using Neo4j graph database.

## 🚀 Features

- **Spring Boot 3.5.5** - Modern Java framework
- **Neo4j Integration** - Graph database for complex movie relationships
- **RESTful API** - Clean and intuitive API endpoints
- **Lombok** - Reduces boilerplate code
- **Java 17** - Latest LTS version

## 🛠️ Tech Stack

- **Backend**: Spring Boot 3.5.5
- **Database**: Neo4j
- **Language**: Java 17
- **Build Tool**: Gradle
- **Dependencies**:
  - Spring Boot Starter Web
  - Spring Boot Starter Data Neo4j
  - Lombok
  - Spring Boot Starter Test

## 📋 Prerequisites

Before running this application, make sure you have:

- **Java 17** or higher
- **Neo4j Database** (local installation or Docker)
- **Gradle** (or use the included Gradle wrapper)

## 🚀 Getting Started

### 1. Clone the Repository

```bash
git clone <repository-url>
cd "Movies Backend"
```

### 2. Set up Neo4j Database

#### Option A: Using Docker
```bash
docker run --name neo4j-movies -p 7474:7474 -p 7687:7687 -e NEO4J_AUTH=neo4j/password neo4j:latest
```

#### Option B: Local Installation
1. Download Neo4j from [neo4j.com](https://neo4j.com/download/)
2. Install and start the Neo4j service
3. Access the web interface at `http://localhost:7474`

### 3. Configure Database Connection

Update `src/main/resources/application.properties`:

```properties
spring.neo4j.uri=bolt://localhost:7687
spring.neo4j.authentication.username=neo4j
spring.neo4j.authentication.password=password
```

### 4. Run the Application

#### Using Gradle Wrapper (Recommended)
```bash
# On Unix/macOS
./gradlew bootRun

# On Windows
gradlew.bat bootRun
```

#### Using Gradle
```bash
gradle bootRun
```

#### Using IDE
Run the `MoviesApplication.java` main class directly.

### 5. Verify Installation

The application will start on `http://localhost:8080` by default.

## 📁 Project Structure

```
src/
├── main/
│   ├── java/
│   │   └── com/baohaukhanh/Movies/
│   │       └── MoviesApplication.java
│   └── resources/
│       ├── application.properties
│       ├── static/
│       └── templates/
└── test/
    └── java/
        └── com/baohaukhanh/Movies/
            └── MoviesApplicationTests.java
```

## 🔧 Configuration

### Application Properties

The main configuration file is located at `src/main/resources/application.properties`:

```properties
spring.application.name=Movies
```

### Database Configuration

Add Neo4j connection properties to `application.properties`:

```properties
# Neo4j Configuration
spring.neo4j.uri=bolt://localhost:7687
spring.neo4j.authentication.username=neo4j
spring.neo4j.authentication.password=your_password
```

## 🧪 Testing

Run the test suite:

```bash
./gradlew test
```

## 📦 Building

### Build JAR file
```bash
./gradlew build
```

The JAR file will be created in `build/libs/` directory.

### Build Docker Image
```bash
./gradlew bootBuildImage
```

## 🚀 Deployment

### Using Docker

1. Build the application:
```bash
./gradlew bootBuildImage
```

2. Run the container:
```bash
docker run -p 8080:8080 movies:0.0.1-SNAPSHOT
```

### Using JAR file

1. Build the JAR:
```bash
./gradlew build
```

2. Run the JAR:
```bash
java -jar build/libs/Movies-0.0.1-SNAPSHOT.jar
```

## 📚 API Documentation

Once the application is running, you can access:

- **Application**: `http://localhost:8080`
- **Neo4j Browser**: `http://localhost:7474` (if running locally)

## 🤝 Contributing

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/amazing-feature`)
3. Commit your changes (`git commit -m 'Add some amazing feature'`)
4. Push to the branch (`git push origin feature/amazing-feature`)
5. Open a Pull Request

## 📝 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## 👨‍💻 Author

**Bao Hau Khanh**
- GitHub: [@baohaukhanh](https://github.com/baohaukhanh)

## 📞 Support

If you have any questions or need help, please:

1. Check the [Issues](https://github.com/your-username/movies-backend/issues) page
2. Create a new issue if your problem isn't already reported
3. Contact the maintainer

## 🔗 Useful Links

- [Spring Boot Documentation](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/)
- [Neo4j Documentation](https://neo4j.com/docs/)
- [Spring Data Neo4j Documentation](https://docs.spring.io/spring-data/neo4j/docs/current/reference/html/)
- [Gradle Documentation](https://docs.gradle.org/)

---

**Happy Coding! 🎬🍿**

