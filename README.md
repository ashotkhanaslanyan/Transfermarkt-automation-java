# ST_Final

Software Testing Class Final Project on https://www.transfermarkt.com/

# Project Setup Instructions

## Prerequisites

Ensure you have the following installed:
- Java Development Kit (JDK) 11 or higher
- Maven
- Docker (for running services with Docker Compose)

## Setup Instructions

### For macOS:

1. **Install Homebrew** (if not already installed):
    ```bash
    /bin/bash -c "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/HEAD/install.sh)"
    ```

2. **Install JDK**:
    ```bash
    brew install openjdk@11
    ```

    After installation, add OpenJDK to your PATH:
    ```bash
    echo 'export PATH="/usr/local/opt/openjdk@11/bin:$PATH"' >> ~/.zshrc
    source ~/.zshrc
    ```

3. **Install Maven**:
    ```bash
    brew install maven
    ```

4. **Install Docker**:
    ```bash
    brew install --cask docker
    open /Applications/Docker.app
    ```

5. **Clone the repository** (adjust URL as necessary):
    ```bash
    git clone <repository-url>
    cd <repository-directory>
    ```

6. **Build the project with Maven**:
    ```bash
    mvn clean install
    ```

7. **Start services using Docker Compose**:
    ```bash
    docker-compose up -d
    ```

### For Windows:

1. **Install JDK**:
    - Download and install from [Oracle JDK](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html) or adopt OpenJDK.

2. **Install Maven**:
    - Download Maven from [Apache Maven](https://maven.apache.org/download.cgi).
    - Extract it to a folder, e.g., `C:\Program Files\Maven`.
    - Add the `bin` directory of the extracted folder to the `PATH` environment variable.

3. **Install Docker Desktop for Windows**:
    - Download Docker Desktop from [Docker Hub](https://hub.docker.com/editions/community/docker-ce-desktop-windows).
    - Follow the installation instructions and ensure it runs on startup.

4. **Clone the repository** (adjust URL as necessary):
    ```cmd
    git clone <repository-url>
    cd <repository-directory>
    ```

5. **Build the project with Maven**:
    ```cmd
    mvn clean install
    ```

6. **Start services using Docker Compose**:
    ```cmd
    docker-compose up -d
    ```

## Additional Notes

- Make sure Docker Desktop is running before executing `docker-compose up`.
- Use the `docker-compose logs` command to check logs for the services.
- Run `mvn test` to execute tests.

