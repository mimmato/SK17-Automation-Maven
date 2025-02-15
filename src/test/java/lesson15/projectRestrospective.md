# Project Summary - XPath Element Analysis

## 1. Project Overview
This project focused on identifying meaningful XPath locators for two pages on the [Skillo](http://training.skillo-bg.com:4200/users/login) website:

http://training.skillo-bg.com:4200/posts/all

http://training.skillo-bg.com:4200/users/login

The goal was to define **reliable and precise** locators for UI elements, ensuring they can be used in future test automation.

## 2. Team Members & Responsibilities

- **Eduard S.**: Analyzed elements on **Page 1** (Home/Posts).
- **Mihail Mihaylov**: Analyzed elements on **Page 2** (Users/Login).

We worked together to identify suitable elements and XPath expressions for both pages, focusing on meaningful and reliable locators. To maintain clarity and efficiency, we limited our findings to 3-4 key categories per page. These categories were chosen based on factors such as element location, functionality, role within the application, and the type of information they hold.

## 3. Key Dates & Milestones
| **Date**    | **Milestone**                                |
|-------------|----------------------------------------------|
| 12-Feb-2025 | Initial contact with potential team members. |
| 13-Feb-2025 | Defining project scope                       |
| 15-Feb-2025 | Team review of XPath expressions.            |
| 17-Feb-2025 | Documentation finalized & submission.        |

## 4. Why We Chose These Elements
Our research focused on finding essential for UI navigation and user authentication elements. The selection criteria included:
- **User Inputs & Buttons**: Login fields, buttons, and feedback messages.
- **Navigation Links & Clickable Items**: Ensuring all main navigation components are covered.
- **UI Feedback & Messages**: Alerts and validation messages for test verification.
- **Posts data & Components**: To find specific attributes of a post i.e. images, author, Like/dislike counts, timestamps etc.

## 5. Categories breakdown

- Navigation Bar Locators – We performed similar checks for the navigation menu since it remains consistent across all pages of the website.
    The goal was to identify expressions that locate essential navigation elements, including buttons and hyperlinks.

Page 1 (Home/Posts):

- Post Locators – We identified expressions to capture all available posts and locate key elements such as timestamps, usernames/authors, feed images, post images, and like/dislike counts.

Page 2 (Users/Login):

- Form Field Locators – Used to verify the presence of essential fields for user login.
- UI Consistency Check – Used to find dynamic elements, including buttons and hyperlinks.
- User Feedback Messages – Used to locate alerts necessary for form validation.

## 6. Next Steps (Automation)
 

We should explain why the locators we picked are suitable for the next steps