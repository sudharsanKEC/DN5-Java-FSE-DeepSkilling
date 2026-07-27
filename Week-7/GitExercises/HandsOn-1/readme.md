# Git Exercise 1 - Git Configuration & Repository Initialization

## Objective

This exercise introduces the basic Git workflow by setting up Git, configuring user information, integrating Notepad++ as the default editor, creating a local Git repository, and connecting it to a remote GitLab repository.

---

# Learning Outcomes

After completing this exercise, I learned how to:

- Install and verify Git.
- Configure Git with username and email.
- Configure Notepad++ as Git's default editor.
- Initialize a Git repository.
- Understand the purpose of the hidden `.git` folder.
- Create and track files using Git.
- Create commits.
- Connect a local repository to a remote GitLab repository.
- Pull changes from the remote repository.
- Push local commits to GitLab.
- Understand Git's working directory, staging area, local repository, and remote repository.

---

# Commands Used

## 1. Verify Git Installation

```bash
git --version
```

### Purpose

Checks whether Git is installed correctly.

Example Output

```text
git version 2.54.0.windows.1
```

---

## 2. Configure Git Username

```bash
git config --global user.name "sudharsanKEC"
```

### Purpose

Sets the author name that will be attached to every commit.

---

## 3. Configure Git Email

```bash
git config --global user.email "sudharsans913@gmail.com"
```

### Purpose

Sets the email address associated with commits.

Git uses this metadata to identify the author of each commit.

---

## 4. Verify Configuration

```bash
git config --global --list
```

### Purpose

Displays the global Git configuration.

---

## 5. Configure Notepad++ as Default Editor

```bash
git config --global core.editor "notepad++.exe -multiInst -nosession"
```

### Purpose

Configures Notepad++ as Git's default editor for commit messages and other editing operations.

---

## 6. Initialize Repository

```bash
git init GitDemo
```

or

```bash
git init
```

### Purpose

Creates a new Git repository.

This creates a hidden folder named:

```text
.git
```

which stores

- Commit history
- Branch information
- Configuration
- References
- Objects
- Tags

---

## 7. Check Repository Status

```bash
git status
```

### Purpose

Displays the current state of the repository.

It shows

- Current branch
- Modified files
- Untracked files
- Staged files
- Repository synchronization status

---

## 8. Create File

```bash
echo "Welcome to the version control" > welcome.txt
```

### Purpose

Creates a file named `welcome.txt`.

---

## 9. Verify Files

```bash
ls -al
```

### Purpose

Lists all files including hidden files.

Useful to verify that `.git` has been created.

---

## 10. View File Contents

```bash
cat welcome.txt
```

### Purpose

Displays the contents of the file.

---

## 11. Stage File

```bash
git add welcome.txt
```

### Purpose

Moves the file from the Working Directory to the Staging Area.

After this command Git starts tracking the file.

---

## 12. Commit Changes

```bash
git commit
```

or

```bash
git commit -m "Initial Commit"
```

### Purpose

Creates a snapshot of all staged files.

A commit permanently records the project's state.

---

## 13. Connect Remote Repository

```bash
git remote add origin https://gitlab.com/username/GitDemo.git
```

### Purpose

Creates a connection between the local repository and the remote GitLab repository.

`origin` is simply the default name of the remote repository.

---

## 14. Verify Remote

```bash
git remote -v
```

### Purpose

Displays the configured remote repositories.

---

## 15. Pull Remote Changes

```bash
git pull origin main --allow-unrelated-histories
```

### Purpose

Downloads commits from GitLab and merges them with the local repository.

The `--allow-unrelated-histories` option was required because both repositories had independent initial commits.

---

## 16. Rename Branch

```bash
git branch -M main
```

### Purpose

Renames the current branch to `main`.

---

## 17. Push Repository

```bash
git push -u origin main
```

### Purpose

Uploads the local repository to GitLab.

The `-u` option sets the upstream relationship so future commands can simply be:

```bash
git push
git pull
```

---

# Concepts Learned

## Working Directory

The folder where project files are created and edited.

Git does not automatically track changes made here.

---

## Staging Area

An intermediate area where selected changes are prepared before committing.

Files are added using

```bash
git add
```

---

## Local Repository

Stored inside the hidden `.git` folder.

Contains

- Commit history
- Branches
- Tags
- Objects
- Repository configuration

---

## Remote Repository

A copy of the project hosted on GitLab.

Used for collaboration and backup.

---

## Git Workflow

```text
Working Directory
        │
git add
        ▼
Staging Area
        │
git commit
        ▼
Local Repository (.git)
        │
git push
        ▼
Remote Repository (GitLab)
```

---

## Git Pull

```text
git pull

=

git fetch

+

git merge
```

It downloads commits from the remote repository and integrates them into the current branch.

---

## Git Fetch

Downloads changes from the remote repository without modifying the current branch.

The downloaded commits are stored locally inside `.git`.

---

## Upstream Branch

After executing

```bash
git push -u origin main
```

Git remembers

```text
Local Branch

main

↓

tracks

↓

origin/main
```

This relationship is called the upstream.

After configuring the upstream, future commands become

```bash
git push
git pull
```

without specifying the remote and branch names.

---

# Repository Architecture

```text
GitDemo/
│
├── .git/
├── welcome.txt
└── README.md
```

---

# Summary

This exercise introduced the complete Git workflow from repository creation to remote synchronization.

The key skills learned include:

- Git installation and configuration
- Repository initialization
- File tracking
- Commit creation
- Remote repository configuration
- Pulling and pushing changes
- Understanding Git architecture
- Understanding Working Directory, Staging Area, Local Repository, and Remote Repository
- Understanding Git Fetch, Git Pull, and Upstream tracking

This forms the foundation for all future Git operations such as branching, merging, rebasing, collaboration, and version control.