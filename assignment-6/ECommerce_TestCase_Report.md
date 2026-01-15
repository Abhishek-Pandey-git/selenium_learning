# Online E-Commerce Website
## Manual Test Case Report

### Project Information
**Project Name:** E-Commerce Platform  
**Test Date:** January 15, 2026  
**Tested By:** QA Team  
**Version:** 1.0

---

## Test Case 1: Customer Registration
**Test Case ID:** EC_TC_001  
**Module:** User Management  
**Priority:** High  
**Prerequisites:** None

| Step | Action | Expected Result | Actual Result | Status |
|------|--------|----------------|---------------|--------|
| 1 | Click Register button | Registration form opens | As expected | Pass |
| 2 | Enter name, email, password | Fields accept input | As expected | Pass |
| 3 | Enter phone and address | Fields accept input | As expected | Pass |
| 4 | Agree to terms and conditions | Checkbox enabled | As expected | Pass |
| 5 | Click Submit | Account created | As expected | Pass |
| 6 | Verify email verification link | Email received | As expected | Pass |

---

## Test Case 2: Vendor Registration
**Test Case ID:** EC_TC_002  
**Module:** Vendor Management  
**Priority:** High  
**Prerequisites:** None

| Step | Action | Expected Result | Actual Result | Status |
|------|--------|----------------|---------------|--------|
| 1 | Navigate to vendor registration | Vendor form displays | As expected | Pass |
| 2 | Enter business details | All fields accept input | As expected | Pass |
| 3 | Upload business documents | Files upload successfully | As expected | Pass |
| 4 | Enter bank details | Secure fields accept input | As expected | Pass |
| 5 | Submit for approval | Pending status assigned | As expected | Pass |

---

## Test Case 3: Browse Product Categories
**Test Case ID:** EC_TC_003  
**Module:** Product Catalog  
**Priority:** Medium  
**Prerequisites:** Products exist in database

| Step | Action | Expected Result | Actual Result | Status |
|------|--------|----------------|---------------|--------|
| 1 | Click on Electronics category | Category page opens | As expected | Pass |
| 2 | View subcategories | All subcategories display | As expected | Pass |
| 3 | Click on Smartphones | Products displayed | As expected | Pass |
| 4 | Verify product thumbnails | Images load correctly | As expected | Pass |
| 5 | Check price display | Prices shown correctly | As expected | Pass |

---

## Test Case 4: Search Products
**Test Case ID:** EC_TC_004  
**Module:** Product Search  
**Priority:** High  
**Prerequisites:** Products exist in catalog

| Step | Action | Expected Result | Actual Result | Status |
|------|--------|----------------|---------------|--------|
| 1 | Enter "laptop" in search box | Suggestions appear | As expected | Pass |
| 2 | Press Enter | Search results display | As expected | Pass |
| 3 | Apply price filter | Results filtered | As expected | Pass |
| 4 | Apply brand filter | Only selected brands show | As expected | Pass |
| 5 | Sort by rating | Products sorted correctly | As expected | Pass |

---

## Test Case 5: View Product Details
**Test Case ID:** EC_TC_005  
**Module:** Product Details  
**Priority:** High  
**Prerequisites:** Product exists

| Step | Action | Expected Result | Actual Result | Status |
|------|--------|----------------|---------------|--------|
| 1 | Click on a product | Product page opens | As expected | Pass |
| 2 | View product images | Gallery displays | As expected | Pass |
| 3 | Read description | Full description visible | As expected | Pass |
| 4 | Check specifications | Specs table displays | As expected | Pass |
| 5 | View customer reviews | Reviews section shows | As expected | Pass |
| 6 | Check stock availability | Stock status displayed | As expected | Pass |

---

## Test Case 6: Add to Cart
**Test Case ID:** EC_TC_006  
**Module:** Shopping Cart  
**Priority:** Critical  
**Prerequisites:** User is logged in

| Step | Action | Expected Result | Actual Result | Status |
|------|--------|----------------|---------------|--------|
| 1 | Select product quantity | Quantity updated | As expected | Pass |
| 2 | Click "Add to Cart" | Success message shown | As expected | Pass |
| 3 | View cart | Product appears in cart | As expected | Pass |
| 4 | Update quantity in cart | Quantity changes | As expected | Pass |
| 5 | Verify price calculation | Subtotal correct | As expected | Pass |

---

## Test Case 7: Add to Wishlist
**Test Case ID:** EC_TC_007  
**Module:** Wishlist  
**Priority:** Low  
**Prerequisites:** User is logged in

| Step | Action | Expected Result | Actual Result | Status |
|------|--------|----------------|---------------|--------|
| 1 | Click heart icon on product | Product added to wishlist | As expected | Pass |
| 2 | Navigate to wishlist | Wishlist page displays | As expected | Pass |
| 3 | View saved products | All items shown | As expected | Pass |
| 4 | Move item to cart | Item removed from wishlist | As expected | Pass |
| 5 | Remove item from wishlist | Item deleted | As expected | Pass |

---

## Test Case 8: Checkout Process
**Test Case ID:** EC_TC_008  
**Module:** Checkout  
**Priority:** Critical  
**Prerequisites:** Items in cart

| Step | Action | Expected Result | Actual Result | Status |
|------|--------|----------------|---------------|--------|
| 1 | Click "Proceed to Checkout" | Checkout page opens | As expected | Pass |
| 2 | Enter shipping address | Address saved | As expected | Pass |
| 3 | Select delivery method | Option selected | As expected | Pass |
| 4 | Apply coupon code | Discount applied | As expected | Pass |
| 5 | Select payment method | Payment options display | As expected | Pass |
| 6 | Enter card details | Secure form accepts input | As expected | Pass |
| 7 | Place order | Order confirmed | As expected | Pass |
| 8 | Receive confirmation email | Email sent | As expected | Pass |

---

## Test Case 9: Track Order
**Test Case ID:** EC_TC_009  
**Module:** Order Management  
**Priority:** Medium  
**Prerequisites:** Order has been placed

| Step | Action | Expected Result | Actual Result | Status |
|------|--------|----------------|---------------|--------|
| 1 | Navigate to "My Orders" | Orders page displays | As expected | Pass |
| 2 | Click on an order | Order details shown | As expected | Pass |
| 3 | View order status | Status displayed | As expected | Pass |
| 4 | Track shipment | Tracking info shown | As expected | Pass |
| 5 | View invoice | PDF invoice generated | As expected | Pass |

---

## Test Case 10: Write Product Review
**Test Case ID:** EC_TC_010  
**Module:** Reviews & Ratings  
**Priority:** Low  
**Prerequisites:** User purchased product

| Step | Action | Expected Result | Actual Result | Status |
|------|--------|----------------|---------------|--------|
| 1 | Go to purchased product | Product page opens | As expected | Pass |
| 2 | Click "Write Review" | Review form displays | As expected | Pass |
| 3 | Rate product (1-5 stars) | Rating selected | As expected | Pass |
| 4 | Write review text | Text area accepts input | As expected | Pass |
| 5 | Upload product photos | Images uploaded | As expected | Pass |
| 6 | Submit review | Review posted | As expected | Pass |

---

## Test Case 11: Vendor Add Product
**Test Case ID:** EC_TC_011  
**Module:** Vendor Portal  
**Priority:** High  
**Prerequisites:** Vendor account approved

| Step | Action | Expected Result | Actual Result | Status |
|------|--------|----------------|---------------|--------|
| 1 | Login as vendor | Vendor dashboard displays | As expected | Pass |
| 2 | Click "Add Product" | Product form opens | As expected | Pass |
| 3 | Enter product details | All fields accept input | As expected | Pass |
| 4 | Upload product images | Images uploaded | As expected | Pass |
| 5 | Set price and stock | Values saved | As expected | Pass |
| 6 | Publish product | Product live on site | As expected | Pass |

---

## Test Case 12: Inventory Management
**Test Case ID:** EC_TC_012  
**Module:** Inventory  
**Priority:** Medium  
**Prerequisites:** Vendor has products

| Step | Action | Expected Result | Actual Result | Status |
|------|--------|----------------|---------------|--------|
| 1 | Navigate to Inventory | Inventory page displays | As expected | Pass |
| 2 | View stock levels | Current stock shown | As expected | Pass |
| 3 | Update stock quantity | Quantity updated | As expected | Pass |
| 4 | Check low stock alert | Alert displayed | As expected | Pass |
| 5 | Export inventory report | CSV downloaded | As expected | Pass |

---

## Test Summary
**Total Test Cases:** 12  
**Passed:** 12  
**Failed:** 0  
**Blocked:** 0  
**Pass Rate:** 100%

## Defects Found
No critical defects identified.

## Recommendations
- All core e-commerce functionalities working properly
- Payment gateway integration is secure
- Ready for production launch
- Monitor system performance during sales events
