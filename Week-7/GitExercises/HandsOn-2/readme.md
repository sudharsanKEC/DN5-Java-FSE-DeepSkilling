# Git Exercise 2 - Ignoring Unwanted Files Using `.gitignore`

## Objective

This exercise demonstrates how Git ignores unnecessary files and folders using the `.gitignore` file. It helps keep the repository clean by preventing temporary, generated, or system-specific files from being tracked.

---

# Learning Outcomes

After completing this exercise, I learned how to:

- Understand the purpose of the `.gitignore` file.
- Ignore files using wildcard patterns.
- Ignore entire folders.
- Verify ignored files using `git status`.
- Commit and push the `.gitignore` configuration.
- Understand the difference between tracked, untracked, and ignored files.

---

# Commands Used

## 1. Create a Log File

```bash
echo "Application Log" > app.log
```

### Purpose

Creates a log file inside the working directory.

Normally, log files are generated automatically by applications and should not be stored in version control.

---

## 2. Create a Log Folder

```bash
mkdir log
```

### Purpose

Creates a folder named `log`.

---

## 3. Create a Log File Inside the Folder

```bash
echo "Error Log" > log/error.log
```

### Purpose

Creates another log file inside the `log` directory.

---

## 4. Create `.gitignore`

```bash
npp .gitignore
```

### Purpose

Opens Notepad++ to create the `.gitignore` file.

The following rules were added:

```text
*.log
log/
```

### Explanation

```text
*.log
```

Ignores every file having the `.log` extension.

Examples:

```text
app.log
server.log
error.log
```

---

```text
log/
```

Ignores the entire folder named `log`.

---

## 5. Verify Repository Status

```bash
git status
```

### Purpose

Displays the current state of the repository.

Expected Output:

```text
Untracked files:
    .gitignore
```

Notice that:

- `app.log` is **not shown**
- `log/` is **not shown**

because Git ignores them based on the rules defined in `.gitignore`.

---

## 6. Stage the `.gitignore` File

```bash
git add .gitignore
```

### Purpose

Stages the `.gitignore` file.

Although `.gitignore` tells Git which files to ignore, the `.gitignore` file itself **should be tracked** because it defines the project's ignore rules.

---

## 7. Commit Changes

```bash
git commit -m "Added .gitignore file"
```

### Purpose

Creates a commit containing the `.gitignore` configuration.

---

## 8. Push Changes

```bash
git push
```

### Purpose

Uploads the commit to the remote GitLab repository.

Since the upstream branch was configured in Exercise 1, only `git push` was required.

---

## 9. Verify Repository Status

```bash
git status
```

Expected Output:

```text
nothing to commit, working tree clean
```

This indicates that:

- All required files are committed.
- Ignored files are hidden from Git.
- The working directory matches the latest commit.

---

# Concepts Learned

## What is `.gitignore`?

`.gitignore` is a configuration file that tells Git which files or folders should **not** be tracked.

Instead of ignoring files manually every time, Git automatically follows the rules defined inside this file.

---

## Why Track `.gitignore`?

Although `.gitignore` is used to ignore files, the file itself **must be tracked**.

Reason:

When another developer clones the repository, they also receive the `.gitignore` file, ensuring everyone follows the same ignore rules.

Without committing `.gitignore`, each developer would have to create it manually.

---

## Ignored Files

Ignored files are files that Git intentionally skips.

Examples include:

- Log files
- Temporary files
- Cache files
- Build artifacts
- IDE configuration files
- Operating system files

These files are usually generated automatically and do not belong in source control.

---

## Wildcard Patterns

The pattern

```text
*.log
```

means:

> Ignore every file ending with `.log`.

Examples:

```text
app.log
server.log
debug.log
```

---

## Ignoring Folders

The rule

```text
log/
```

means:

> Ignore the entire `log` directory along with all its contents.

---

## Tracked vs Untracked vs Ignored Files

### Tracked Files

Files that Git is already monitoring.

Example:

```text
welcome.txt
README.md
.gitignore
```

---

### Untracked Files

Files that Git has discovered but is not yet tracking.

Example:

```text
notes.txt
```

These appear in:

```bash
git status
```

until they are added using:

```bash
git add
```

---

### Ignored Files

Files matching the rules inside `.gitignore`.

Example:

```text
app.log
log/
```

These files do **not** appear in `git status`.

---

## Purpose of `git status`

The `git status` command provides the current state of the repository.

It displays:

- Current branch
- Synchronization with the remote repository
- Staged files
- Modified files
- Untracked files
- Ignored files (hidden by default)
- Repository cleanliness

Example:

```text
On branch main
Your branch is up to date with 'origin/main'.

nothing to commit, working tree clean
```

---

## Important Note

`.gitignore` only affects **untracked files**.

If a file has already been committed, adding it to `.gitignore` will **not** stop Git from tracking it.

To stop tracking an already committed file:

```bash
git rm --cached filename
```

Then commit the changes.

---

# Workflow

```text
Working Directory
        │
        │
        ▼
Git checks .gitignore
        │
 ┌──────┴─────────┐
 │                │
 ▼                ▼
Ignored       Not Ignored
 │                │
 │                ▼
 │            git add
 │                │
 │                ▼
 │          Staging Area
 │                │
 │                ▼
 │           git commit
 │                │
 └──────────────► Local Repository
                         │
                         ▼
                    git push
                         │
                         ▼
                  Remote Repository
```

---

# Repository Structure

```text
GitDemo/
│
├── .git/
├── .gitignore
├── welcome.txt
├── README.md
├── app.log        (Ignored)
└── log/           (Ignored)
```

---

# Summary

This exercise introduced Git's ignore mechanism using the `.gitignore` file.

The key concepts learned include:

- Creating and configuring `.gitignore`
- Ignoring files using wildcard patterns
- Ignoring folders
- Understanding tracked, untracked, and ignored files
- Understanding why `.gitignore` itself should be committed
- Using `git status` to verify repository state
- Maintaining a clean repository by excluding unnecessary files

This exercise establishes one of the most important best practices in version control: **only source code and project configuration should be committed, while generated and temporary files should remain outside the repository.**