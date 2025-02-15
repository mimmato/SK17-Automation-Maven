# Project Summary - XPath Element Analysis

## 1. Project Overview
This project focused on identifying meaningful XPath locators for two pages on the [Skillo](http://training.skillo-bg.com:4200/users/login) website:

http://training.skillo-bg.com:4200/posts/all

http://training.skillo-bg.com:4200/users/login

The goal was to define **reliable and precise** locators for UI elements, ensuring they can be used in future test automation.

## 2. Team Members & Responsibilities

- **Eduard S.**: Analyzed elements on **Page 1** (Home/Posts).
- **Mihail Mihaylov**: Analyzed elements on **Page 2** (Users/Login).

- **Collaboration**: We worked together to refine expressions, review accuracy, and document findings.

## 3. Key Dates & Milestones
| **Date**    | **Milestone**                                |
|-------------|----------------------------------------------|
| 12-Feb-2025 | Initial contact with potential team members. |
| 13-Feb-2025 | Defining project scope                       |
| 15-Feb-2025 | Team review of XPath expressions.            |
| 17-Feb-2025 | Documentation finalized & submission.        |

## 4. Why We Chose These Elements
Our analysis focused on **critical interactive elements** that are essential for UI navigation and user authentication. The selection criteria included:
- **User Inputs & Buttons**: Login fields, buttons, and feedback messages.
- **Navigation Links & Clickable Items**: Ensuring all main navigation components are covered.
- **UI Feedback & Messages**: Capturing alerts and validation messages for test verification.

## 5. Challenges & Solutions
| **Challenge** | **Solution** |
|--------------|-------------|
| Some elements had dynamic attributes (e.g., changing IDs). | Used stable attributes like `formcontrolname` and `class`. |
| Multiple similar elements made XPath selection tricky. | Used more specific expressions with `contains()` and direct attributes. |
| Ensuring XPath expressions were valid and efficient. | Regular reviews and testing to refine locators. |

## 6. Next Steps (Automation)
- Use these locators in **test automation scripts**.
- Maintain documentation to update XPath selectors as the UI evolves.
- Consider CSS selectors as an alternative for some cases.  

We should explain why the locators we picked are suitable for the next steps