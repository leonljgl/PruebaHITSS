# TEST_STRATEGY

## 1. What would you not automate in this flow, and why?

I would not automate scenarios that depend on unstable external factors, such as temporary promotions, advertising banners, or UI elements that change frequently without affecting the core business functionality.

I would focus automation on the critical user journey: searching for a product, validating that results are displayed, and verifying essential information such as product name and Price, as this exercise does. Visual appearance and marketing content are better suited for manual or visual regression testing because they generate high maintenance cost and low business value.

---

## 2. If Liverpool added a CAPTCHA to the search flow, how would you handle it in your test suite?

I would not automate solving a CAPTCHA, because its purpose is to prevent automated access.

Instead, I would separate the automated suite from anti-bot mechanisms by using dedicated test environments. If none of these options were available, I would stop the automation before the CAPTCHA and continue validating the remaining business logic through API or integration tests.

---

## 3. What flakiness risks exist in this test, and how did you mitigate them?

The main flakiness risks are dynamic page loading, asynchronous rendering, changing locators, and anti-bot protection.

To reduce instability, explicit & implicit waits were implemented instead of fixed delays, stable locators were preferred whenever possible, and Page Object Model was used to focus on locator maintenance. The execution was also configured in headless mode with browser options suitable for CI environments. Additionally, automatic screenshots and Allure reports help diagnosing failures in a quick manner.

---