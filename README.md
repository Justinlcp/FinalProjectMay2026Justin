Library Management System
Justin Lachapelle Id: 2583626

Project Overview
This project is a library management system developed entirely as the final project for the class Object-Oriented Programming at College Vanier. The system models a library environment where users can borrow and return library items, search for specific titles and generate reports. The project focuses on applying many things we learned this semester such as class design, inheritance, polymorphism, exception handling, file I/O and unit testing. It is built using Java, Maven, Lombok and JUnit 5.

System Capabilities
* Borrowing and returning library items (Books, DVDs, Magazines)
* User management (Students, Teachers, Admins)
* Searching items by title using recursive and stream methods
* Sorting items and users using different strategies
* Generating reports of all library items and their statuses
* Loading and backing up data using CSV files
* Exception handling for invalid operations
* Input validation

Class Overview and Responsibilities

Item
Represents an abstract library item.
Responsibilities:
* Stores the item ID, title and status
* Automatically generates item IDs
* Defines the base structure for all library items

Book
Represents a book in the library.
Responsibilities:
* Stores ISBN, title, author and genre
* Extends Item

DVD
Represents a DVD in the library.
Responsibilities:
* Stores title, director and duration
* Extends Item

Magazine
Represents a magazine in the library.
Responsibilities:
* Stores title, issue number and publisher
* Extends Item

User
Represents an abstract user of the library.
Responsibilities:
* Stores user ID, name and list of borrowed items
* Automatically generates user IDs
* Defines the base structure for all user types

Student
Represents a student user.
Responsibilities:
* Can borrow up to 5 books
* Extends User

Teacher
Represents a teacher user.
Responsibilities:
* Can borrow up to 10 items
* Extends User

Admin
Represents an admin user.
Responsibilities:
* Generates reports of all library items
* Backs up items and users to CSV files
* Implements Reportable interface
* Extends User

Library
Represents the library itself.
Responsibilities:
* Manages all items and users
* Handles borrowing and returning of items
* Provides recursive and stream search methods

LibraryService
Utility service class for sorting.
Responsibilities:
* Sorts items by title or status
* Sorts users by name

Enumerations
ItemStatus: Restricts item status to IN_STORE, BORROWED and LOST

Unit Testing
JUnit 5 test methods included for:
* Borrow and return logic
* Exception handling
* Search methods
* Validation methods
