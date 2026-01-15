# Customer Relationship Management (CRM) System
## Manual Test Case Report

### Project Information
**Project Name:** CRM System  
**Test Date:** January 15, 2026  
**Tested By:** QA Team  
**Version:** 1.0

---

## Test Case 1: User Registration
**Test Case ID:** CRM_TC_001  
**Module:** User Management  
**Priority:** High  
**Prerequisites:** Application is accessible

| Step | Action | Expected Result | Actual Result | Status |
|------|--------|----------------|---------------|--------|
| 1 | Navigate to registration page | Registration form displays | As expected | Pass |
| 2 | Enter valid username, email, password | Fields accept input | As expected | Pass |
| 3 | Select user role (Admin/Sales/Marketing) | Dropdown shows options | As expected | Pass |
| 4 | Click Submit button | Success message displays | As expected | Pass |
| 5 | Verify email confirmation sent | Email received | As expected | Pass |

---

## Test Case 2: User Login
**Test Case ID:** CRM_TC_002  
**Module:** Authentication  
**Priority:** Critical  
**Prerequisites:** User account exists

| Step | Action | Expected Result | Actual Result | Status |
|------|--------|----------------|---------------|--------|
| 1 | Navigate to login page | Login form displays | As expected | Pass |
| 2 | Enter valid credentials | Fields accept input | As expected | Pass |
| 3 | Click Login button | Redirect to dashboard | As expected | Pass |
| 4 | Verify session created | User logged in successfully | As expected | Pass |

---

## Test Case 3: Add New Customer
**Test Case ID:** CRM_TC_003  
**Module:** Customer Management  
**Priority:** High  
**Prerequisites:** User is logged in

| Step | Action | Expected Result | Actual Result | Status |
|------|--------|----------------|---------------|--------|
| 1 | Click "Add Customer" button | Customer form opens | As expected | Pass |
| 2 | Enter customer name | Field accepts input | As expected | Pass |
| 3 | Enter email and phone | Fields accept input | As expected | Pass |
| 4 | Enter company and address | Fields accept input | As expected | Pass |
| 5 | Click Save | Customer saved successfully | As expected | Pass |
| 6 | Verify in customer list | New customer appears | As expected | Pass |

---

## Test Case 4: Search Customer
**Test Case ID:** CRM_TC_004  
**Module:** Customer Management  
**Priority:** Medium  
**Prerequisites:** Customers exist in database

| Step | Action | Expected Result | Actual Result | Status |
|------|--------|----------------|---------------|--------|
| 1 | Enter customer name in search box | Search field accepts input | As expected | Pass |
| 2 | Click Search button | Matching customers display | As expected | Pass |
| 3 | Apply filter by company | Results filtered correctly | As expected | Pass |
| 4 | Clear search | All customers display | As expected | Pass |

---

## Test Case 5: Create Lead
**Test Case ID:** CRM_TC_005  
**Module:** Lead Management  
**Priority:** High  
**Prerequisites:** User is logged in as Sales Rep

| Step | Action | Expected Result | Actual Result | Status |
|------|--------|----------------|---------------|--------|
| 1 | Navigate to Leads section | Leads page displays | As expected | Pass |
| 2 | Click "Add Lead" button | Lead form opens | As expected | Pass |
| 3 | Enter lead details | Fields accept input | As expected | Pass |
| 4 | Select lead source | Dropdown shows options | As expected | Pass |
| 5 | Assign lead stage (Prospect) | Stage selected | As expected | Pass |
| 6 | Click Save | Lead created successfully | As expected | Pass |

---

## Test Case 6: Update Lead Status
**Test Case ID:** CRM_TC_006  
**Module:** Sales Pipeline  
**Priority:** High  
**Prerequisites:** Lead exists in system

| Step | Action | Expected Result | Actual Result | Status |
|------|--------|----------------|---------------|--------|
| 1 | Open lead details | Lead information displays | As expected | Pass |
| 2 | Change stage to "Qualified" | Stage updates in dropdown | As expected | Pass |
| 3 | Add notes | Notes field accepts input | As expected | Pass |
| 4 | Click Update | Changes saved | As expected | Pass |
| 5 | Verify in pipeline view | Lead moved to new stage | As expected | Pass |

---

## Test Case 7: Log Customer Interaction
**Test Case ID:** CRM_TC_007  
**Module:** Activity Tracking  
**Priority:** Medium  
**Prerequisites:** Customer exists

| Step | Action | Expected Result | Actual Result | Status |
|------|--------|----------------|---------------|--------|
| 1 | Open customer profile | Profile page displays | As expected | Pass |
| 2 | Click "Log Activity" | Activity form opens | As expected | Pass |
| 3 | Select activity type (Call/Email) | Type selected | As expected | Pass |
| 4 | Enter activity details | Details saved | As expected | Pass |
| 5 | Set follow-up date | Date picker works | As expected | Pass |
| 6 | Click Save | Activity logged | As expected | Pass |

---

## Test Case 8: Create Email Campaign
**Test Case ID:** CRM_TC_008  
**Module:** Marketing Automation  
**Priority:** Medium  
**Prerequisites:** User is logged in as Marketer

| Step | Action | Expected Result | Actual Result | Status |
|------|--------|----------------|---------------|--------|
| 1 | Navigate to Campaigns | Campaigns page displays | As expected | Pass |
| 2 | Click "Create Campaign" | Campaign builder opens | As expected | Pass |
| 3 | Enter campaign name | Field accepts input | As expected | Pass |
| 4 | Select customer segment | Segment options display | As expected | Pass |
| 5 | Design email template | Template editor works | As expected | Pass |
| 6 | Schedule campaign | Date/time picker works | As expected | Pass |
| 7 | Click Launch | Campaign scheduled | As expected | Pass |

---

## Test Case 9: View Sales Dashboard
**Test Case ID:** CRM_TC_009  
**Module:** Analytics & Reporting  
**Priority:** Medium  
**Prerequisites:** Sales data exists

| Step | Action | Expected Result | Actual Result | Status |
|------|--------|----------------|---------------|--------|
| 1 | Navigate to Dashboard | Dashboard displays | As expected | Pass |
| 2 | View total sales KPI | Correct value shows | As expected | Pass |
| 3 | Check conversion rate | Percentage displays | As expected | Pass |
| 4 | View pipeline chart | Chart renders correctly | As expected | Pass |
| 5 | Apply date filter | Data updates accordingly | As expected | Pass |

---

## Test Case 10: Export Customer Data
**Test Case ID:** CRM_TC_010  
**Module:** Data Export  
**Priority:** Low  
**Prerequisites:** Customer data exists

| Step | Action | Expected Result | Actual Result | Status |
|------|--------|----------------|---------------|--------|
| 1 | Navigate to Customers | Customer list displays | As expected | Pass |
| 2 | Click "Export" button | Export options show | As expected | Pass |
| 3 | Select CSV format | Format selected | As expected | Pass |
| 4 | Click Download | File downloads | As expected | Pass |
| 5 | Open CSV file | Data formatted correctly | As expected | Pass |

---

## Test Summary
**Total Test Cases:** 10  
**Passed:** 10  
**Failed:** 0  
**Blocked:** 0  
**Pass Rate:** 100%

## Defects Found
No critical defects found during testing.

## Recommendations
- System is ready for production deployment
- Monitor performance during peak usage
- Schedule regular security audits
