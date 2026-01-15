# Healthcare Management System
## Manual Test Case Report

### Project Information
**Project Name:** Healthcare Management System  
**Test Date:** January 15, 2026  
**Tested By:** QA Team  
**Version:** 1.0

---

## Test Case 1: Patient Registration
**Test Case ID:** HMS_TC_001  
**Module:** Patient Management  
**Priority:** High  
**Prerequisites:** None

| Step | Action | Expected Result | Actual Result | Status |
|------|--------|----------------|---------------|--------|
| 1 | Navigate to registration page | Form displays | As expected | Pass |
| 2 | Enter patient name | Field accepts input | As expected | Pass |
| 3 | Enter date of birth | Date picker works | As expected | Pass |
| 4 | Select gender | Dropdown displays options | As expected | Pass |
| 5 | Enter contact details | Phone/email validated | As expected | Pass |
| 6 | Enter address | All fields accept input | As expected | Pass |
| 7 | Enter emergency contact | Details saved | As expected | Pass |
| 8 | Submit registration | Patient ID generated | As expected | Pass |

---

## Test Case 2: Doctor Registration
**Test Case ID:** HMS_TC_002  
**Module:** Doctor Management  
**Priority:** High  
**Prerequisites:** Valid medical credentials

| Step | Action | Expected Result | Actual Result | Status |
|------|--------|----------------|---------------|--------|
| 1 | Navigate to doctor registration | Form displays | As expected | Pass |
| 2 | Enter doctor details | Fields accept input | As expected | Pass |
| 3 | Select specialization | Dropdown shows specialties | As expected | Pass |
| 4 | Upload medical license | Document uploaded | As expected | Pass |
| 5 | Upload degree certificates | Documents uploaded | As expected | Pass |
| 6 | Set consultation fee | Amount saved | As expected | Pass |
| 7 | Submit for verification | Pending status assigned | As expected | Pass |

---

## Test Case 3: Search Doctor
**Test Case ID:** HMS_TC_003  
**Module:** Doctor Search  
**Priority:** High  
**Prerequisites:** Doctors registered in system

| Step | Action | Expected Result | Actual Result | Status |
|------|--------|----------------|---------------|--------|
| 1 | Navigate to Find Doctor | Search page displays | As expected | Pass |
| 2 | Select specialty (Cardiology) | Filter applied | As expected | Pass |
| 3 | Select location | Location filter applied | As expected | Pass |
| 4 | View search results | Doctors displayed | As expected | Pass |
| 5 | View doctor profile | Details shown | As expected | Pass |
| 6 | Check availability | Calendar displays | As expected | Pass |

---

## Test Case 4: Book Appointment
**Test Case ID:** HMS_TC_004  
**Module:** Appointment Booking  
**Priority:** Critical  
**Prerequisites:** Patient logged in, doctor available

| Step | Action | Expected Result | Actual Result | Status |
|------|--------|----------------|---------------|--------|
| 1 | Select a doctor | Doctor profile opens | As expected | Pass |
| 2 | Click "Book Appointment" | Booking form displays | As expected | Pass |
| 3 | Select appointment date | Date selected from calendar | As expected | Pass |
| 4 | Select time slot | Available slots shown | As expected | Pass |
| 5 | Enter reason for visit | Text area accepts input | As expected | Pass |
| 6 | Confirm booking | Appointment confirmed | As expected | Pass |
| 7 | Receive confirmation email | Email sent | As expected | Pass |

---

## Test Case 5: View Medical History
**Test Case ID:** HMS_TC_005  
**Module:** Electronic Health Records  
**Priority:** High  
**Prerequisites:** Patient has medical history

| Step | Action | Expected Result | Actual Result | Status |
|------|--------|----------------|---------------|--------|
| 1 | Login as patient | Dashboard displays | As expected | Pass |
| 2 | Navigate to Medical History | History page opens | As expected | Pass |
| 3 | View past consultations | List displayed | As expected | Pass |
| 4 | View prescribed medications | Medications shown | As expected | Pass |
| 5 | View lab reports | Reports accessible | As expected | Pass |
| 6 | Download medical records | PDF generated | As expected | Pass |

---

## Test Case 6: Upload Medical Documents
**Test Case ID:** HMS_TC_006  
**Module:** Document Management  
**Priority:** Medium  
**Prerequisites:** Patient logged in

| Step | Action | Expected Result | Actual Result | Status |
|------|--------|----------------|---------------|--------|
| 1 | Navigate to Documents | Document page displays | As expected | Pass |
| 2 | Click "Upload Document" | Upload dialog opens | As expected | Pass |
| 3 | Select document type | Dropdown shows types | As expected | Pass |
| 4 | Choose file | File browser opens | As expected | Pass |
| 5 | Upload PDF/Image | File uploaded successfully | As expected | Pass |
| 6 | Add description | Text saved | As expected | Pass |
| 7 | Verify in document list | Document appears | As expected | Pass |

---

## Test Case 7: Video Consultation
**Test Case ID:** HMS_TC_007  
**Module:** Telemedicine  
**Priority:** Critical  
**Prerequisites:** Video appointment booked

| Step | Action | Expected Result | Actual Result | Status |
|------|--------|----------------|---------------|--------|
| 1 | Navigate to upcoming appointments | Appointments displayed | As expected | Pass |
| 2 | Click "Join Video Call" | Waiting room opens | As expected | Pass |
| 3 | Allow camera/microphone | Permissions granted | As expected | Pass |
| 4 | Wait for doctor | Waiting status shown | As expected | Pass |
| 5 | Doctor joins call | Video starts | As expected | Pass |
| 6 | Test audio/video | Working properly | As expected | Pass |
| 7 | End consultation | Call ended successfully | As expected | Pass |

---

## Test Case 8: Create Digital Prescription
**Test Case ID:** HMS_TC_008  
**Module:** Prescription Management  
**Priority:** High  
**Prerequisites:** Doctor logged in, patient consultation done

| Step | Action | Expected Result | Actual Result | Status |
|------|--------|----------------|---------------|--------|
| 1 | Open patient record | Record displays | As expected | Pass |
| 2 | Click "Create Prescription" | Prescription form opens | As expected | Pass |
| 3 | Add medication | Medicine search works | As expected | Pass |
| 4 | Specify dosage | Dosage fields accept input | As expected | Pass |
| 5 | Add instructions | Text saved | As expected | Pass |
| 6 | Add multiple medicines | All added to list | As expected | Pass |
| 7 | Save prescription | Prescription saved | As expected | Pass |
| 8 | Patient receives notification | Email/SMS sent | As expected | Pass |

---

## Test Case 9: Book Lab Test
**Test Case ID:** HMS_TC_009  
**Module:** Lab Services  
**Priority:** Medium  
**Prerequisites:** Patient logged in

| Step | Action | Expected Result | Actual Result | Status |
|------|--------|----------------|---------------|--------|
| 1 | Navigate to Lab Tests | Lab page displays | As expected | Pass |
| 2 | Browse test categories | Categories shown | As expected | Pass |
| 3 | Select blood test | Test details displayed | As expected | Pass |
| 4 | Select lab center | Available labs shown | As expected | Pass |
| 5 | Choose date and time | Slot booked | As expected | Pass |
| 6 | Make payment | Payment successful | As expected | Pass |
| 7 | Receive confirmation | Booking confirmed | As expected | Pass |

---

## Test Case 10: View Lab Reports
**Test Case ID:** HMS_TC_010  
**Module:** Lab Reports  
**Priority:** Medium  
**Prerequisites:** Lab test completed

| Step | Action | Expected Result | Actual Result | Status |
|------|--------|----------------|---------------|--------|
| 1 | Login as patient | Dashboard displays | As expected | Pass |
| 2 | Navigate to Lab Reports | Reports page opens | As expected | Pass |
| 3 | View completed tests | Test list displayed | As expected | Pass |
| 4 | Click on a report | Report details shown | As expected | Pass |
| 5 | Download report PDF | PDF downloaded | As expected | Pass |
| 6 | Share with doctor | Share option works | As expected | Pass |

---

## Test Case 11: Billing and Payment
**Test Case ID:** HMS_TC_011  
**Module:** Billing  
**Priority:** High  
**Prerequisites:** Service rendered

| Step | Action | Expected Result | Actual Result | Status |
|------|--------|----------------|---------------|--------|
| 1 | View bill details | Itemized bill shown | As expected | Pass |
| 2 | Check consultation fee | Fee displayed correctly | As expected | Pass |
| 3 | Check additional charges | All charges listed | As expected | Pass |
| 4 | Apply insurance | Discount applied | As expected | Pass |
| 5 | Select payment method | Options displayed | As expected | Pass |
| 6 | Enter card details | Secure form accepts input | As expected | Pass |
| 7 | Complete payment | Payment successful | As expected | Pass |
| 8 | Download invoice | PDF generated | As expected | Pass |

---

## Test Case 12: Set Medication Reminder
**Test Case ID:** HMS_TC_012  
**Module:** Health Tracking  
**Priority:** Low  
**Prerequisites:** Patient logged in, prescription exists

| Step | Action | Expected Result | Actual Result | Status |
|------|--------|----------------|---------------|--------|
| 1 | Navigate to Reminders | Reminder page displays | As expected | Pass |
| 2 | Click "Add Reminder" | Reminder form opens | As expected | Pass |
| 3 | Select medication | Medicine selected | As expected | Pass |
| 4 | Set reminder times | Times configured | As expected | Pass |
| 5 | Set frequency | Frequency selected | As expected | Pass |
| 6 | Save reminder | Reminder activated | As expected | Pass |
| 7 | Receive test notification | Notification received | As expected | Pass |

---

## Test Summary
**Total Test Cases:** 12  
**Passed:** 12  
**Failed:** 0  
**Blocked:** 0  
**Pass Rate:** 100%

## HIPAA Compliance Check
- Patient data encryption verified
- Access control working properly
- Audit logs maintained
- Data backup tested

## Defects Found
No critical defects found.

## Recommendations
- System meets healthcare compliance standards
- Video consultation quality is good
- Ready for pilot deployment
- Monitor system during peak hours
