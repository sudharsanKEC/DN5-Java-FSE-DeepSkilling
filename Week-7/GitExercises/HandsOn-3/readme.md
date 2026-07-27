# Git Exercise 3 - Branching and Merging

## Objective

This exercise introduces one of Git's most powerful features: **branching and merging**.

A branch allows developers to work independently without affecting the main project. After completing the work, the branch can be merged back into the main branch.

This exercise also demonstrates how Git compares branches, merges changes, and maintains project history.

---

# Learning Outcomes

After completing this exercise, I learned how to:

- Create a new Git branch.
- Switch between branches.
- Understand how branches work internally.
- Commit changes in a separate branch.
- Compare two branches.
- View differences using both Git CLI and Visual Diff Tool.
- Merge a feature branch into the main branch.
- Understand Fast-Forward Merge.
- Visualize commit history.
- Delete a merged branch.

---

# Commands Used

## 1. View Current Branch

```bash
git branch
```

### Purpose

Displays all local branches.

The `*` symbol indicates the currently active branch.

Example

```text
* main
```

---

## 2. Create a New Branch

```bash
git branch GitNewBranch
```

### Purpose

Creates a new branch named `GitNewBranch`.

The current branch remains unchanged.

---

## 3. Create and Switch Together

```bash
git switch -c GitNewBranch
```

or

```bash
git checkout -b GitNewBranch
```

### Purpose

Creates the branch and immediately switches to it.

---

## 4. List Local and Remote Branches

```bash
git branch -a
```

### Purpose

Displays

- Local branches
- Remote branches

Example

```text
* GitNewBranch
  main
  remotes/origin/main
```

---

## 5. Switch Between Branches

```bash
git switch GitNewBranch
```

or

```bash
git checkout GitNewBranch
```

### Purpose

Moves the HEAD pointer to another branch.

---

## 6. Create a New File

```bash
echo "The file is created in GitNewBranch" > branch.txt
```

### Purpose

Creates a new file inside the feature branch.

---

## 7. Check Repository Status

```bash
git status
```

### Purpose

Verifies the current state of the repository.

---

## 8. Stage Changes

```bash
git add branch.txt
```

### Purpose

Moves the file into the Staging Area.

---

## 9. Commit Changes

```bash
git commit -m "Added branch.txt in GitNewBranch"
```

### Purpose

Creates a snapshot of the feature branch.

---

## 10. Switch Back to Main

```bash
git switch main
```

### Purpose

Returns to the main development branch.

---

## 11. Compare Branches

```bash
git diff main GitNewBranch
```

### Purpose

Displays all differences between two branches.

Example

```diff
+ The file is created in GitNewBranch
```

---

## 12. Visual Comparison

```bash
git difftool main GitNewBranch
```

or

Visual comparison using VS Code.

### Purpose

Displays graphical differences between branches.

---

## 13. Merge Branch

```bash
git merge GitNewBranch
```

### Purpose

Integrates all commits from `GitNewBranch` into `main`.

In this exercise Git performed a **Fast-Forward Merge** because there were no conflicting commits.

---

## 14. View Commit History

```bash
git log --oneline --graph --decorate
```

### Purpose

Displays a graphical representation of the commit history.

Example

```text
* abc123 (HEAD -> main, GitNewBranch)
* 06e847d
* 36bd045
```

---

## 15. Delete Branch

```bash
git branch -d GitNewBranch
```

### Purpose

Deletes the branch after it has been merged.

---

## 16. Verify Repository Status

```bash
git status
```

Expected Output

```text
nothing to commit, working tree clean
```

---

# Concepts Learned

## What is a Branch?

A branch is an independent line of development.

Instead of modifying the main project directly, developers create branches to work on new features or bug fixes.

Example

```text
main
 │
 └── GitNewBranch
```

---

## Why Use Branches?

Without branches:

```text
Everyone edits main
```

which can easily break the application.

With branches:

```text
Developer A
       │
Feature Branch

Developer B
       │
Bug Fix Branch

Developer C
       │
UI Branch
```

Each developer works independently.

---

## HEAD

HEAD represents the current working branch.

Example

```text
HEAD
 │
 ▼
GitNewBranch
```

When switching branches, HEAD moves.

---

## How Git Creates a Branch

Git does **not** copy all project files.

Instead, it creates another pointer to the current commit.

Example

Before

```text
A ─── B ─── C (main)
```

After

```text
A ─── B ─── C
             ▲
             │
         GitNewBranch
```

Both branches point to the same commit.

No files are duplicated.

---

## Branch Independence

After switching to

```text
GitNewBranch
```

new commits only affect that branch.

Example

```text
A ─── B ─── C (main)
             \
              D (GitNewBranch)
```

---

## Git Diff

`git diff` compares two branches or commits.

Example

```bash
git diff main GitNewBranch
```

Git highlights

- Added lines
- Removed lines
- Modified lines

---

## Visual Diff

Visual diff tools like

- VS Code
- P4Merge
- Beyond Compare

display differences graphically.

---

## Merge

A merge combines two independent branches.

Example

Before

```text
main

A ─── B ─── C

GitNewBranch

A ─── B ─── C ─── D
```

After Merge

```text
A ─── B ─── C ─── D
                 ▲
               main
```

---

## Fast-Forward Merge

A Fast-Forward Merge occurs when the destination branch has not changed after the feature branch was created.

Instead of creating a merge commit,

Git simply moves the branch pointer.

---

## Merge Commit

If both branches contain new commits,

Git creates an additional commit called the Merge Commit.

Example

```text
        D
       /
A ─ B ─ C
       \
        E

         \
          M
```

---

## Git Log

```bash
git log --oneline --graph --decorate
```

Displays

- Branches
- Commits
- Merge history
- HEAD
- Tags

as a commit graph.

---

## Branch Deletion

After successful merging,

the feature branch can be safely deleted.

Deleting the branch does **not** delete its commits because they are now part of `main`.

---

# Workflow

```text
main
 │
 │ Create Branch
 ▼
GitNewBranch
 │
 │ Add Files
 │
 │ Commit
 ▼
Compare Branches
 │
 │ Merge
 ▼
main
 │
 │ Delete Branch
 ▼
Repository Clean
```

---

# Repository Structure

```text
GitDemo/
│
├── .git/
├── welcome.txt
├── branch.txt
├── .gitignore
└── README.md
```

---

# Summary

This exercise demonstrated Git's branching and merging workflow.

The major concepts learned include:

- Creating branches
- Switching branches
- Understanding HEAD
- Branch pointers
- Independent development
- Comparing branches
- Visual comparison
- Fast-Forward Merge
- Merge Commit
- Commit Graph
- Branch deletion

Branching is one of Git's most important features because it allows multiple developers to work independently without affecting the main project until their work is ready to be merged.