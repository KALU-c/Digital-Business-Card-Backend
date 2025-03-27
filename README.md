# Digital Business Card Generator - Backend  

This repository contains the backend implementation of the Digital Business Card Generator project, developed using Spring Boot. The backend handles the creation of QR codes based on user-provided contact details and serves them as downloadable PNG files.

---

## Features  

- REST API to accept contact details in JSON format.
- Converts contact details into vCard format.
- Generates QR codes using the ZXing library.
- Serves QR codes as downloadable PNG files.
- Handles errors gracefully, including file handling and QR code generation issues.

---

## Technologies Used  

- **Spring Boot:** For building the backend application.  
- **ZXing Library:** For generating QR codes.  
- **Java 17+:** The programming language for development.  
- **Maven:** For dependency management.  

---

## API Endpoints  

### POST `/api/qrcode`  
Generates a QR code for the provided contact details.

- **Request Body (JSON):**  
```json
{
  "fullName": {
    "firstName": "John",
    "lastName": "Doe"
  },
  "phoneNumber": "1234567890",
  "email": "johndoe@example.com",
  "company": "Example Inc.",
  "jobTitle": "Software Engineer",
  "address": {
    "street": "123 Main St",
    "city": "Metropolis",
    "zip": "12345",
    "country": "USA"
  },
  "website": "https://example.com"
}
```

- **Response:**  
  - **200 OK:** PNG file containing the QR code.  
  - **500 Internal Server Error:** If an error occurs during QR code generation or file handling.  

---

## How It Works  

1. **Contact Details Input:**  
   - User submits contact details through the frontend.  
   - Details are sent to the `/api/qrcode` endpoint as a JSON payload.  

2. **vCard Conversion:**  
   - The backend converts the JSON data into a vCard format using the `VCardGenerator` utility.  

3. **QR Code Generation:**  
   - The vCard is used as the input to generate a QR code using the ZXing library.  

4. **Response:**  
   - The generated QR code is returned as a downloadable PNG file.

---

## Exception Handling  

- **WriterException:**  
  - Handles QR code generation errors caused by invalid input or encoding issues.  

- **IOException:**  
  - Manages file-related errors, such as problems with saving or reading the QR code.  

- **General Error Handling:**  
  - Ensures the backend responds with meaningful error messages and maintains system stability.

---

## Directory Structure  

```
src/main/java/com/dbc/card/
├── controller/       # Contains the REST controller for handling API requests.
├── model/            # Defines the data models for ContactData and related objects.
├── service/          # Contains business logic for QR code generation.
├── util/             # Utility classes like VCardGenerator for vCard formatting.
└── QrCodeGeneratorApplication.java  # Main entry point of the application.
```

---

## Setup Instructions  

### Prerequisites  
- JDK 17+  
- Maven  
- A working directory for storing generated QR codes.  

### Installation  

1. Clone the repository:  
   ```bash
   git clone https://github.com/KALU-c/Digital-Business-Card-Backend.git
   cd Digital-Business-Card-Backend
   ```

2. Build the project using Maven:  
   ```bash
   mvn clean install
   ```

3. Run the application:  
   ```bash
   mvn spring-boot:run
   ```

4. Test the API using tools like Postman or curl.

---

## Future Enhancements  

- Add support for custom QR code designs.  
- Integrate cloud storage for QR codes.  
- Implement user authentication for better security.  

---

## License  

This project is licensed under the MIT License. You are free to use, modify, and distribute this software, provided that the original copyright notice and permission notice are included in all copies or substantial portions of the software.  

---

## Contact  

For questions or suggestions, please reach out to the development team:  
- **Endekalu Zemenu** - Backend Developer  
- **Email:** endekaluzemenu2134@gmail.com  
- **GitHub:** [KALU-c](https://github.com/KALU-c)  
