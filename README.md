# DrBook
Team 2

Member: Max Chen, Nancy Xie, Nancy Dominguez, Linh Truong, Shakti Suman
<img src="pic/logo.jpg" width="700">

---

# Description
We propose to create an appointment booking app for doctors' appointments where a patient can go online and self schedule an appointment with a doctor.

---
The app would have following features

- __Appointment Management__:
	- have the doctors' schedules and creates open slots that the user can choose from to book an appointment.
	- The appointment will have the patient information and appointment details.
	- Allow user to cancel or change appointment.
- __User Management__: Hold the user information in order for the user to use the appointment booking app.
- __Patient Management__: Hold patient information such as their name, address, medical history, etc.and their appointment bookings and details
- __Doctor Management__: Hold the doctor name, specialties, and availability
- __Admin Management__: Hold select users. These authorized users can add doctors and have the ability to reset passwords

---

# Why we need DrBook?

- Doctors need to make appointments for their patients more efficiently and so that it’s more readily available to their patients.
- With an online booking system, doctors would be able to provide a cutting edge service that only a few practices offer - which in turn attracts and retains customers. Therefore, an online booking system would boost revenue and staff efficiency along with minimizing no-shows.
---

# Why we need DrBook?
- Taking out the middleman and allowing the patients themselves to book their own appointments in real time.
- Increase staff efficiency by allowing them to focus on their current tasks and will boost revenue through increased new patient intake and retainability.
- Simplify the whole process of booking an appointment for a patient and makes it more seamless and efficient for all parties.

---

# Approach
Follow Agile methodology

- Iteration 1: project proposal, elaboration, Installation and Setup, Customize Login System, Fetch doctor, Fetch doctor’s schedule (display), Create dummy patient homepage, Book a slot

- Iteration 2: Change/Cancel slot, Patient profile (Info, homepage),  Doctor profile (Info, homepage), Doctor slot management

- Iteration 3: Add User (any actor), Password reset (for everyone)

---


# Main features

1. The Actors:	Patient, doctor, admin

2. Features / Function / requirements*
	- User management
		- Functionality involving a login system, patient registration and password recovery
	- Appointment management:
		- Functionality that involves booking a doctor and a time slot, and being able to manage slots
	- Patient management
	- Doctors management
	- Admin management

3. Stories
	- User management
		- Login System (Directs user to specific actor page)
		- Patient Registration
		- Patient password recovery
		- Secret questions

	- Appointment management
		- Fetch doctor
		- Fetch doctor’s schedule (display)
		- Book a slot
		- With appointment details
		- Change/Cancel slot

	- Patient Management
		- Patient profile
			- Information (including Medical History)
			- Homepage

	- Doctor Management
		- Doctor profile
			- Information
			- Homepage
		- Doctor slot management

	- Admin Management
		- Add User (any actor)
			- Only admin can add doctors
		- Password reset (for everyone)


4. Enhancements:
	- Recommender system between doctors and patients
	- Rating system
	- Transaction management
		- User can see their history information (diagnosis, medication)
