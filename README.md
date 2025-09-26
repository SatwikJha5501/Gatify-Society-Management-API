# Gatify - Society Management System

Gatify is a comprehensive society management system built with Spring Boot that handles resident management, complaints, entry approvals, notices, and flat management for residential societies.

## 🚀 Features

- **Society Management**: Manage multiple societies with blocks and flats
- **User Management**: Resident, Manager, and Security Guard role management
- **Complaint System**: Handle maintenance complaints with assignment tracking
- **Entry Approval**: Manage visitor and service personnel entry requests
- **Pre-Entry Approval**: Schedule guest, cab, delivery, and visiting help entries
- **Notice Board**: Digital notice system for society announcements
- **Flat Management**: Complete flat inventory with area details
- **REST API**: Full CRUD operations for all entities

## 🛠️ Technology Stack

- **Backend**: Spring Boot 3.x
- **Database**: MySQL
- **ORM**: Hibernate/JPA
- **Validation**: Jakarta Validation
- **Build Tool**: Maven

## 📋 Prerequisites

- Java 17 or higher
- MySQL Server 8.0+
- Maven 3.6+
- Postman (for API testing)

## 🌐 API Endpoints

### Society Management
- `GET /api/societies` - Get all societies
- `GET /api/societies/{id}` - Get society by ID
- `POST /api/societies` - Create new society
- `PUT /api/societies` - Update society
- `DELETE /api/societies/{id}` - Delete society

### Block Management
- `GET /api/blocks` - Get all blocks
- `GET /api/blocks/{id}` - Get block by ID
- `POST /api/blocks` - Create new block
- `PUT /api/blocks` - Update block
- `DELETE /api/blocks/{id}` - Delete block

### Flat Management
- `GET /api/flats` - Get all flats
- `GET /api/flats/{id}` - Get flat by ID
- `POST /api/flats` - Create new flat
- `PUT /api/flats` - Update flat
- `DELETE /api/flats/{id}` - Delete flat

### User Management
- `GET /api/users` - Get all users
- `GET /api/users/{id}` - Get user by ID
- `POST /api/users` - Create new user
- `PUT /api/users` - Update user
- `DELETE /api/users/{id}` - Delete user

### Complaint Management
- `GET /api/complaints` - Get all complaints
- `GET /api/complaints/{id}` - Get complaint by ID
- `POST /api/complaints` - Create new complaint
- `PUT /api/complaints` - Update complaint
- `PATCH /api/complaints/{id}/assign` - Assign personnel to complaint
- `DELETE /api/complaints/{id}` - Delete complaint

### Entry Approval Management
- `GET /api/entry-approvals` - Get all entry approvals
- `GET /api/entry-approvals/{id}` - Get entry approval by ID
- `POST /api/entry-approvals` - Create new entry approval
- `PUT /api/entry-approvals` - Update entry approval
- `PATCH /api/entry-approvals/{id}/status` - Update approval status
- `DELETE /api/entry-approvals/{id}` - Delete entry approval

### Pre-Entry Approval Management
- `GET /api/pre-entry-approvals` - Get all pre-entry approvals
- `GET /api/pre-entry-approvals/{id}` - Get pre-entry approval by ID
- `POST /api/pre-entry-approvals` - Create new pre-entry approval
- `PUT /api/pre-entry-approvals` - Update pre-entry approval
- `DELETE /api/pre-entry-approvals/{id}` - Delete pre-entry approval

### Notice Management
- `GET /api/notices` - Get all notices
- `GET /api/notices/{id}` - Get notice by ID
- `POST /api/notices` - Create new notice
- `PUT /api/notices` - Update notice
- `DELETE /api/notices/{id}` - Delete notice

### User-Flat Relation Management
- `GET /api/user-flat-relations` - Get all user-flat relations
- `GET /api/user-flat-relations/{id}` - Get relation by ID
- `POST /api/user-flat-relations` - Create new relation
- `PUT /api/user-flat-relations` - Update relation
- `PATCH /api/user-flat-relations/{id}/status` - Update relation status
- `DELETE /api/user-flat-relations/{id}` - Delete relation

## 📱 Postman API Examples

### Create Society
```http
POST http://localhost:8080/api/societies
Content-Type: application/json

{
    "societyName": "Green Valley Residency",
    "location": "Sector 45",
    "area": "Gurugram",
    "numberOfBlocks": 5,
    "pinCode": "122003"
}
```

### Create Block
```http
POST http://localhost:8080/api/blocks
Content-Type: application/json

{
    "blockName": "A",
    "society": {
        "id": 1
    }
}
```

### Create Flat
```http
POST http://localhost:8080/api/flats
Content-Type: application/json

{
    "flatNumber": "101",
    "type": "2BHK",
    "carpetArea": 950.0,
    "blockArea": 1200.0,
    "block": {
        "id": 1
    },
    "society": {
        "id": 1
    }
}
```

### Create User (Resident)
```http
POST http://localhost:8080/api/users
Content-Type: application/json

{
    "firstname": "Rahul",
    "lastname": "Sharma",
    "gmail": "rahul.sharma@example.com",
    "mobileNumber": "9876543210",
    "type": "Resident"
}
```

### Create User (Manager)
```http
POST http://localhost:8080/api/users
Content-Type: application/json

{
    "firstname": "Priya",
    "lastname": "Verma",
    "gmail": "manager@greenvalley.com",
    "mobileNumber": "9876543211",
    "type": "Manager"
}
```

### Create Complaint
```http
POST http://localhost:8080/api/complaints
Content-Type: application/json

{
    "userId": 1,
    "societyId": 1,
    "blockId": 1,
    "flatId": 1,
    "complaintType": "Electrician",
    "complaintStatus": "Pending"
}
```

### Assign Personnel to Complaint
```http
PATCH http://localhost:8080/api/complaints/1/assign
Content-Type: application/json

{
    "personAssignedName": "Rajesh Kumar",
    "personAssignedNumber": "9876543212"
}
```

### Create Entry Approval
```http
POST http://localhost:8080/api/entry-approvals
Content-Type: application/json

{
    "companyName": "Amazon Delivery",
    "flatResident": {
        "id": 1
    },
    "entererName": "Delivery Agent",
    "status": "Pending"
}
```

### Update Entry Approval Status
```http
PATCH http://localhost:8080/api/entry-approvals/1/status
Content-Type: application/json

{
    "status": "Approved"
}
```

### Create Pre-Entry Approval
```http
POST http://localhost:8080/api/pre-entry-approvals
Content-Type: application/json

{
    "type": "Delivery",
    "status": "UsualDelivery",
    "date": "15:12:2024",
    "startingTime": "02:30 PM",
    "hours": 1,
    "companyName": "Swiggy"
}
```

### Create Notice
```http
POST http://localhost:8080/api/notices
Content-Type: application/json

{
    "noticeMessage": "Water supply will be unavailable from 10 AM to 2 PM on December 20th for maintenance work.",
    "userId": 2,
    "userMobileNumber": "9876543211"
}
```

### Create User-Flat Relation
```http
POST http://localhost:8080/api/user-flat-relations
Content-Type: application/json

{
    "userId": 1,
    "societyId": 1,
    "blockId": 1,
    "flatId": 1,
    "status": "PENDING"
}
```

### Update User-Flat Relation Status
```http
PATCH http://localhost:8080/api/user-flat-relations/1/status
Content-Type: application/json

{
    "status": "ACTIVE"
}
```

## 📝 Entity Relationships

- Society has multiple Blocks
- Block has multiple Flats
- User can be associated with multiple Flats through UserFlatRelation
- Complaint links User, Society, Block, and Flat
- EntryApproval links User (flat resident) with entry requests
- Notice is created by Users (typically Managers)

## 🎯 Status Enums

### Complaint Type
- `Electrician`, `Plumber`, `Launderer`, `Carpenter`, `PestControl`

### Complaint Status
- `Pending`, `Assigned`, `Resolved`

### Entry Approval Status
- `Pending`, `Approved`, `Declined`

### Pre-Entry Approval Type
- `Guest`, `Cab`, `Delivery`, `VisitingHelp`

### Pre-Entry Approval Status
- `SurpriseDelivery`, `UsualDelivery`

### User Type
- `Resident`, `Manager`, `SecurityGuard`

### User-Flat Relation Status
- `PENDING`, `ACTIVE`, `INACTIVE`

### Flat Type
- `1BHK`, `2BHK`, `3BHK`

## 🗄️ Database Schema

The system uses MySQL with the following key tables:
- `society` - Society master data
- `block` - Block information linked to societies
- `flat` - Flat details linked to blocks and societies
- `user` - User accounts with role-based access
- `complaint` - Maintenance complaint tracking
- `entry_approval` - Real-time entry requests
- `pre_entry_approval` - Scheduled entry approvals
- `notice` - Society announcements
- `user_flat_relation` - Many-to-many relationship between users and flats

## 🤝 Contributing

1. Fork the project
2. Create your feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## 📄 License

This project is licensed under the MIT License - see the LICENSE file for details.

## 👥 Authors

Gatify Team - Initial work
