# Travel Booking Platform
## Manual Test Case Report

### Project Information
**Project Name:** Travel Booking Platform  
**Test Date:** January 15, 2026  
**Tested By:** QA Team  
**Version:** 1.0

---

## Test Case 1: User Registration
**Test Case ID:** TBP_TC_001  
**Module:** User Management  
**Priority:** High  
**Prerequisites:** None

| Step | Action | Expected Result | Actual Result | Status |
|------|--------|----------------|---------------|--------|
| 1 | Navigate to registration page | Form displays correctly | As expected | Pass |
| 2 | Enter name, email, password | Fields accept input | As expected | Pass |
| 3 | Enter phone number | Field validates format | As expected | Pass |
| 4 | Click Register | Account created | As expected | Pass |
| 5 | Verify confirmation email | Email received | As expected | Pass |

---

## Test Case 2: Social Login (Google)
**Test Case ID:** TBP_TC_002  
**Module:** Authentication  
**Priority:** Medium  
**Prerequisites:** Valid Google account

| Step | Action | Expected Result | Actual Result | Status |
|------|--------|----------------|---------------|--------|
| 1 | Click "Login with Google" | Google auth page opens | As expected | Pass |
| 2 | Enter Google credentials | Login successful | As expected | Pass |
| 3 | Authorize application | Permission granted | As expected | Pass |
| 4 | Redirect to dashboard | User logged in | As expected | Pass |

---

## Test Case 3: Search Flights
**Test Case ID:** TBP_TC_003  
**Module:** Flight Search  
**Priority:** Critical  
**Prerequisites:** User is logged in

| Step | Action | Expected Result | Actual Result | Status |
|------|--------|----------------|---------------|--------|
| 1 | Enter departure city | Autocomplete shows cities | As expected | Pass |
| 2 | Enter destination city | Autocomplete shows cities | As expected | Pass |
| 3 | Select travel dates | Date picker works | As expected | Pass |
| 4 | Select passenger count | Dropdown shows options | As expected | Pass |
| 5 | Click Search | Flights display | As expected | Pass |
| 6 | Verify flight details | Price, time, airline shown | As expected | Pass |

---

## Test Case 4: Filter Flight Results
**Test Case ID:** TBP_TC_004  
**Module:** Flight Search  
**Priority:** Medium  
**Prerequisites:** Search results displayed

| Step | Action | Expected Result | Actual Result | Status |
|------|--------|----------------|---------------|--------|
| 1 | Apply price range filter | Results filtered | As expected | Pass |
| 2 | Select specific airline | Only that airline shows | As expected | Pass |
| 3 | Filter by departure time | Matching flights display | As expected | Pass |
| 4 | Sort by price (low to high) | Results sorted correctly | As expected | Pass |
| 5 | Clear all filters | All results return | As expected | Pass |

---

## Test Case 5: Search Hotels
**Test Case ID:** TBP_TC_005  
**Module:** Hotel Search  
**Priority:** High  
**Prerequisites:** User is logged in

| Step | Action | Expected Result | Actual Result | Status |
|------|--------|----------------|---------------|--------|
| 1 | Enter destination city | Field accepts input | As expected | Pass |
| 2 | Select check-in date | Date picker works | As expected | Pass |
| 3 | Select check-out date | Date picker works | As expected | Pass |
| 4 | Enter number of guests | Field accepts number | As expected | Pass |
| 5 | Click Search Hotels | Hotels display | As expected | Pass |
| 6 | View hotel details | Images, amenities shown | As expected | Pass |

---

## Test Case 6: Add to Cart
**Test Case ID:** TBP_TC_006  
**Module:** Booking Cart  
**Priority:** High  
**Prerequisites:** Flight/hotel search completed

| Step | Action | Expected Result | Actual Result | Status |
|------|--------|----------------|---------------|--------|
| 1 | Select a flight | Flight details display | As expected | Pass |
| 2 | Click "Add to Cart" | Item added to cart | As expected | Pass |
| 3 | View cart | Flight appears in cart | As expected | Pass |
| 4 | Select a hotel | Hotel details display | As expected | Pass |
| 5 | Add hotel to cart | Both items in cart | As expected | Pass |
| 6 | Verify total price | Correct sum displayed | As expected | Pass |

---

## Test Case 7: Apply Promo Code
**Test Case ID:** TBP_TC_007  
**Module:** Promotions  
**Priority:** Medium  
**Prerequisites:** Items in cart

| Step | Action | Expected Result | Actual Result | Status |
|------|--------|----------------|---------------|--------|
| 1 | Navigate to checkout | Checkout page displays | As expected | Pass |
| 2 | Enter valid promo code | Field accepts input | As expected | Pass |
| 3 | Click Apply | Discount applied | As expected | Pass |
| 4 | Verify discounted price | Price reduced correctly | As expected | Pass |
| 5 | Try invalid code | Error message shown | As expected | Pass |

---

## Test Case 8: Payment Process
**Test Case ID:** TBP_TC_008  
**Module:** Payment  
**Priority:** Critical  
**Prerequisites:** Items in cart, user at checkout

| Step | Action | Expected Result | Actual Result | Status |
|------|--------|----------------|---------------|--------|
| 1 | Enter card number | Field validates format | As expected | Pass |
| 2 | Enter expiry date | Field validates date | As expected | Pass |
| 3 | Enter CVV | Field masks input | As expected | Pass |
| 4 | Enter billing address | All fields accept input | As expected | Pass |
| 5 | Click Pay Now | Payment processing | As expected | Pass |
| 6 | Verify confirmation | Booking confirmed | As expected | Pass |
| 7 | Check confirmation email | Email received | As expected | Pass |

---

## Test Case 9: View Booking History
**Test Case ID:** TBP_TC_009  
**Module:** Booking Management  
**Priority:** Medium  
**Prerequisites:** User has made bookings

| Step | Action | Expected Result | Actual Result | Status |
|------|--------|----------------|---------------|--------|
| 1 | Navigate to "My Bookings" | Bookings page displays | As expected | Pass |
| 2 | View booking list | All bookings shown | As expected | Pass |
| 3 | Click on a booking | Details displayed | As expected | Pass |
| 4 | Download voucher | PDF generated | As expected | Pass |
| 5 | Verify voucher content | All details correct | As expected | Pass |

---

## Test Case 10: Cancel Booking
**Test Case ID:** TBP_TC_010  
**Module:** Booking Management  
**Priority:** High  
**Prerequisites:** Active booking exists

| Step | Action | Expected Result | Actual Result | Status |
|------|--------|----------------|---------------|--------|
| 1 | Open booking details | Details page displays | As expected | Pass |
| 2 | Click "Cancel Booking" | Confirmation popup shows | As expected | Pass |
| 3 | Confirm cancellation | Processing message shown | As expected | Pass |
| 4 | Verify cancellation | Status updated to Cancelled | As expected | Pass |
| 5 | Check refund initiated | Refund message displayed | As expected | Pass |

---

## Test Summary
**Total Test Cases:** 10  
**Passed:** 10  
**Failed:** 0  
**Blocked:** 0  
**Pass Rate:** 100%

## Defects Found
No critical defects found.

## Recommendations
- System performs well under normal load
- Payment gateway integration is stable
- Ready for production deployment
