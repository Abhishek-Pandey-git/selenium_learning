# Automated Banking Website
## Manual Test Case Report

### Project Information
**Project Name:** Automated Banking System  
**Test Date:** January 15, 2026  
**Tested By:** QA Team  
**Version:** 1.0

---

## Test Case 1: Customer Registration
**Test Case ID:** BANK_TC_001  
**Module:** User Registration  
**Priority:** Critical  
**Prerequisites:** Valid KYC documents

| Step | Action | Expected Result | Actual Result | Status |
|------|--------|----------------|---------------|--------|
| 1 | Navigate to registration page | Form displays | As expected | Pass |
| 2 | Enter personal details | Fields accept input | As expected | Pass |
| 3 | Upload KYC documents | Documents uploaded | As expected | Pass |
| 4 | Enter PAN and Aadhaar | Validation successful | As expected | Pass |
| 5 | Set security questions | Questions saved | As expected | Pass |
| 6 | Submit application | Pending approval status | As expected | Pass |

---

## Test Case 2: Login with OTP
**Test Case ID:** BANK_TC_002  
**Module:** Authentication  
**Priority:** Critical  
**Prerequisites:** Account is active

| Step | Action | Expected Result | Actual Result | Status |
|------|--------|----------------|---------------|--------|
| 1 | Enter customer ID | Field accepts input | As expected | Pass |
| 2 | Enter password | Password masked | As expected | Pass |
| 3 | Click Login | OTP sent to mobile | As expected | Pass |
| 4 | Enter OTP | OTP validated | As expected | Pass |
| 5 | Access granted | Dashboard displays | As expected | Pass |

---

## Test Case 3: View Account Balance
**Test Case ID:** BANK_TC_003  
**Module:** Account Dashboard  
**Priority:** High  
**Prerequisites:** User is logged in

| Step | Action | Expected Result | Actual Result | Status |
|------|--------|----------------|---------------|--------|
| 1 | Navigate to Dashboard | Dashboard displays | As expected | Pass |
| 2 | View all accounts | Accounts listed | As expected | Pass |
| 3 | Check savings account balance | Balance shown | As expected | Pass |
| 4 | Check current account balance | Balance shown | As expected | Pass |
| 5 | Verify last updated time | Timestamp displayed | As expected | Pass |

---

## Test Case 4: View Transaction History
**Test Case ID:** BANK_TC_004  
**Module:** Transactions  
**Priority:** High  
**Prerequisites:** Transactions exist

| Step | Action | Expected Result | Actual Result | Status |
|------|--------|----------------|---------------|--------|
| 1 | Click "Transaction History" | History page opens | As expected | Pass |
| 2 | View recent transactions | List displays | As expected | Pass |
| 3 | Filter by date range | Results filtered | As expected | Pass |
| 4 | Filter by transaction type | Specific types shown | As expected | Pass |
| 5 | Download statement | PDF generated | As expected | Pass |

---

## Test Case 5: Fund Transfer (Own Accounts)
**Test Case ID:** BANK_TC_005  
**Module:** Fund Transfer  
**Priority:** Critical  
**Prerequisites:** Multiple accounts exist

| Step | Action | Expected Result | Actual Result | Status |
|------|--------|----------------|---------------|--------|
| 1 | Click "Transfer Funds" | Transfer page opens | As expected | Pass |
| 2 | Select source account | Account selected | As expected | Pass |
| 3 | Select destination account | Account selected | As expected | Pass |
| 4 | Enter amount | Field validates amount | As expected | Pass |
| 5 | Enter transaction PIN | PIN masked | As expected | Pass |
| 6 | Confirm transfer | OTP sent | As expected | Pass |
| 7 | Enter OTP | Transfer processed | As expected | Pass |
| 8 | View confirmation | Receipt displayed | As expected | Pass |

---

## Test Case 6: Add Beneficiary
**Test Case ID:** BANK_TC_006  
**Module:** Beneficiary Management  
**Priority:** High  
**Prerequisites:** User is logged in

| Step | Action | Expected Result | Actual Result | Status |
|------|--------|----------------|---------------|--------|
| 1 | Navigate to Beneficiaries | Beneficiary page opens | As expected | Pass |
| 2 | Click "Add Beneficiary" | Form displays | As expected | Pass |
| 3 | Enter beneficiary name | Field accepts input | As expected | Pass |
| 4 | Enter account number | Field validates format | As expected | Pass |
| 5 | Enter IFSC code | IFSC validated | As expected | Pass |
| 6 | Submit request | Verification pending | As expected | Pass |

---

## Test Case 7: NEFT Transfer
**Test Case ID:** BANK_TC_007  
**Module:** Fund Transfer  
**Priority:** Critical  
**Prerequisites:** Verified beneficiary exists

| Step | Action | Expected Result | Actual Result | Status |
|------|--------|----------------|---------------|--------|
| 1 | Select transfer type (NEFT) | NEFT selected | As expected | Pass |
| 2 | Select beneficiary | Beneficiary selected | As expected | Pass |
| 3 | Enter transfer amount | Amount accepted | As expected | Pass |
| 4 | Enter purpose | Text field accepts input | As expected | Pass |
| 5 | Review transfer details | Summary displayed | As expected | Pass |
| 6 | Enter transaction PIN | PIN validated | As expected | Pass |
| 7 | Confirm with OTP | Transfer initiated | As expected | Pass |
| 8 | View transaction ID | Unique ID generated | As expected | Pass |

---

## Test Case 8: Pay Utility Bill
**Test Case ID:** BANK_TC_008  
**Module:** Bill Payments  
**Priority:** High  
**Prerequisites:** User is logged in

| Step | Action | Expected Result | Actual Result | Status |
|------|--------|----------------|---------------|--------|
| 1 | Navigate to Bill Payment | Bill payment page opens | As expected | Pass |
| 2 | Select biller category | Categories displayed | As expected | Pass |
| 3 | Select electricity provider | Provider selected | As expected | Pass |
| 4 | Enter consumer number | Field validates format | As expected | Pass |
| 5 | Fetch bill details | Bill amount displayed | As expected | Pass |
| 6 | Confirm payment | OTP sent | As expected | Pass |
| 7 | Enter OTP | Payment processed | As expected | Pass |
| 8 | Download receipt | PDF generated | As expected | Pass |

---

## Test Case 9: Open Fixed Deposit
**Test Case ID:** BANK_TC_009  
**Module:** Fixed Deposits  
**Priority:** Medium  
**Prerequisites:** Sufficient balance in account

| Step | Action | Expected Result | Actual Result | Status |
|------|--------|----------------|---------------|--------|
| 1 | Navigate to Fixed Deposits | FD page displays | As expected | Pass |
| 2 | Click "Open New FD" | FD form opens | As expected | Pass |
| 3 | Select source account | Account selected | As expected | Pass |
| 4 | Enter FD amount | Amount validated | As expected | Pass |
| 5 | Select tenure | Tenure options shown | As expected | Pass |
| 6 | View interest rate | Rate displayed | As expected | Pass |
| 7 | Calculate maturity amount | Calculation shown | As expected | Pass |
| 8 | Confirm FD opening | FD created successfully | As expected | Pass |

---

## Test Case 10: Apply for Personal Loan
**Test Case ID:** BANK_TC_010  
**Module:** Loan Services  
**Priority:** Medium  
**Prerequisites:** User is logged in

| Step | Action | Expected Result | Actual Result | Status |
|------|--------|----------------|---------------|--------|
| 1 | Navigate to Loans | Loan page displays | As expected | Pass |
| 2 | Select Personal Loan | Loan form opens | As expected | Pass |
| 3 | Enter loan amount | Field accepts input | As expected | Pass |
| 4 | Select tenure | Options displayed | As expected | Pass |
| 5 | Check eligibility | Eligibility result shown | As expected | Pass |
| 6 | Upload income documents | Documents uploaded | As expected | Pass |
| 7 | Submit application | Application submitted | As expected | Pass |
| 8 | View application status | Pending status displayed | As expected | Pass |

---

## Test Case 11: Block/Unblock Debit Card
**Test Case ID:** BANK_TC_011  
**Module:** Card Management  
**Priority:** High  
**Prerequisites:** Active debit card exists

| Step | Action | Expected Result | Actual Result | Status |
|------|--------|----------------|---------------|--------|
| 1 | Navigate to Card Services | Card page displays | As expected | Pass |
| 2 | View active cards | Cards listed | As expected | Pass |
| 3 | Click "Block Card" | Confirmation popup shows | As expected | Pass |
| 4 | Confirm blocking | Card blocked successfully | As expected | Pass |
| 5 | Click "Unblock Card" | Unblock initiated | As expected | Pass |
| 6 | Enter OTP | Card unblocked | As expected | Pass |

---

## Test Case 12: Generate Account Statement
**Test Case ID:** BANK_TC_012  
**Module:** Statements  
**Priority:** Medium  
**Prerequisites:** Transactions exist

| Step | Action | Expected Result | Actual Result | Status |
|------|--------|----------------|---------------|--------|
| 1 | Navigate to Statements | Statement page opens | As expected | Pass |
| 2 | Select account | Account selected | As expected | Pass |
| 3 | Select date range | Dates selected | As expected | Pass |
| 4 | Choose format (PDF/Excel) | Format selected | As expected | Pass |
| 5 | Click Generate | Statement generated | As expected | Pass |
| 6 | Download statement | File downloaded | As expected | Pass |

---

## Test Summary
**Total Test Cases:** 12  
**Passed:** 12  
**Failed:** 0  
**Blocked:** 0  
**Pass Rate:** 100%

## Security Testing
- SSL/TLS encryption verified
- Session timeout working (5 minutes)
- OTP expiry working (10 minutes)
- Transaction PIN encryption verified

## Defects Found
No critical security or functional defects found.

## Recommendations
- System meets banking security standards
- All transaction flows tested successfully
- Ready for production deployment
- Schedule regular penetration testing
