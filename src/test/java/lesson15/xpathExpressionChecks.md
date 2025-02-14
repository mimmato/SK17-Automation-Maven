# Sign In (Login) - [Link](http://training.skillo-bg.com:4200/users/login)

**Mihail Mihaylov**

## Description and XPath Expressions

### Form Field Locators:
| **Description** | **Expression** | **Result** |
|-----------------|----------------|------------|
| Finding all user input fields - formcontrolname attribute | `//input[@formcontrolname]` | N/A |
| Finding specific user input fields - usernameOrEmail | `//input[@formcontrolname="usernameOrEmail"]` | `<input _ngcontent-doh-c8="" class="form-control mb-4 ng-pristine ng-invalid ng-touched" formcontrolname="usernameOrEmail" id="defaultLoginFormUsername" name="usernameOrEmail" placeholder="Username or email" type="text">` |
| Finding specific user input fields - defaultLoginFormPassword | `//input[@formcontrolname="password"]` | `<input _ngcontent-doh-c8="" class="form-control mb-4 ng-untouched ng-pristine ng-invalid" formcontrolname="password" id="defaultLoginFormPassword" name="password" placeholder="Password" type="password">` |
| Finding specific user input fields - rememberMe | `//input[@formcontrolname="rememberMe"]` | `<input _ngcontent-doh-c8="" class="remember-me-button ng-untouched ng-pristine ng-valid" formcontrolname="rememberMe" type="checkbox">` |

### UI Consistency Check:
| **Description** | **Expression** | **Result** |
|-----------------|----------------|------------|
| Finding all clickable elements i.e. buttons and hyperlinks | `//button \| //a` | N/A |
| Finding specific element based on `<button>` tag and the containing word "Sign" | `//button[contains(text(), "Sign")]` | `<button _ngcontent-doh-c8="" block="true" class="my-4 btn btn-primary" id="sign-in-button" type="submit">Sign in</button>` |

### User Feedback Messages:
| **Description** | **Expression** | **Result** |
|-----------------|----------------|------------|
| Finding results using the role attribute | `//div[@role]` | N/A |
| Finding results using the role attribute and specific user feedback | `//div[@role="alertdialog"]` | `<div aria-live="polite" role="alertdialog" class="toast-message ng-star-inserted" aria-label="Successful login!" style=""> Successful login! </div>`<br>`<div aria-live="polite" role="alertdialog" class="toast-message ng-star-inserted" aria-label="Successful logout!" style=""> Successful logout! </div>`<br>`<div aria-live="polite" role="alertdialog" class="toast-message ng-star-inserted" aria-label="User not found" style=""> User not found </div>`<br>`<div aria-live="polite" role="alertdialog" class="toast-message ng-star-inserted" aria-label="UsernameOrEmail cannot be empty" style=""> UsernameOrEmail cannot be empty </div>`<br>`<div aria-live="polite" role="alertdialog" class="toast-message ng-star-inserted" aria-label="Password cannot be empty" style=""> Password cannot be empty </div>` |

