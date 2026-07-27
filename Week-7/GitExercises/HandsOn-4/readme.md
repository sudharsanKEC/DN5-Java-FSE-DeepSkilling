# Git Exercise 4 - Resolving Merge Conflicts

## Objective

This exercise demonstrates how Git detects merge conflicts and how developers manually resolve them before completing a merge.

A merge conflict occurs when Git cannot automatically determine which changes should be kept because two branches have modified the same file (or the same part of a file) independently.

---

# Learning Outcomes

After completing this exercise, I learned how to:

- Create an independent feature branch.
- Modify the same file differently in two branches.
- Understand why merge conflicts occur.
- Compare branch differences.
- Resolve merge conflicts manually.
- Understand Git conflict markers.
- Complete a merge after conflict resolution.
- Understand merge commits.
- Visualize branch history after merging.
- Delete merged branches.

---

# Commands Used

## 1. Verify Repository Status

```bash
git status
```

### Purpose

Ensures that the repository is clean before beginning the exercise.

Expected Output

```text
nothing to commit, working tree clean
```

---

## 2. Create and Switch to a New Branch

```bash
git switch -c GitWork
```

### Purpose

Creates a new branch named `GitWork` and immediately switches to it.

---

## 3. Create hello.xml

```bash
echo "<message>Hello from GitWork</message>" > hello.xml
```

### Purpose

Creates a new XML file inside the GitWork branch.

---

## 4. Verify File Content

```bash
cat hello.xml
```

---

## 5. Check Repository Status

```bash
git status
```

Shows that `hello.xml` is an untracked file.

---

## 6. Stage the File

```bash
git add hello.xml
```

---

## 7. Commit the Changes

```bash
git commit -m "Added hello.xml in GitWork"
```

Creates a snapshot of the GitWork branch.

---

## 8. Switch Back to Main

```bash
git switch main
```

Notice that `hello.xml` disappears because it exists only in the GitWork branch.

---

## 9. Create hello.xml Again

```bash
echo "<message>Hello from Main</message>" > hello.xml
```

Unlike the previous branch, this file contains different content.

---

## 10. Commit the File

```bash
git add hello.xml

git commit -m "Added hello.xml in main"
```

---

## 11. View Complete Commit Graph

```bash
git log --oneline --graph --decorate --all
```

### Purpose

Displays every branch and commit in graphical form.

---

## 12. Compare Both Branches

```bash
git diff main GitWork
```

Shows the textual differences.

---

## 13. Visual Comparison

```bash
git difftool main GitWork
```

Displays graphical differences using the configured diff tool (VS Code/P4Merge).

---

## 14. Merge Branch

```bash
git merge GitWork
```

Git attempts to merge GitWork into main.

Since both branches created `hello.xml` independently with different contents, Git cannot decide which version to keep.

Expected Output

```text
Auto-merging hello.xml
CONFLICT (add/add): Merge conflict in hello.xml
Automatic merge failed; fix conflicts and then commit the result.
```

---

## 15. Resolve the Conflict

Git inserts conflict markers:

```xml
<<<<<<< HEAD
<message>Hello from Main</message>
=======
<message>Hello from GitWork</message>
>>>>>>> GitWork
```

Resolve the conflict manually or use VS Code options:

- Accept Current Change
- Accept Incoming Change
- Accept Both Changes
- Compare Changes

After deciding, remove the conflict markers and save the file.

Example:

```xml
<messages>
    <message>Hello from Main</message>
    <message>Hello from GitWork</message>
</messages>
```

---

## 16. Mark Conflict as Resolved

```bash
git add hello.xml
```

This tells Git that the conflict has been resolved.

---

## 17. Complete the Merge

```bash
git commit -m "Resolved merge conflict in hello.xml"
```

Creates a Merge Commit.

---

## 18. Check Repository Status

```bash
git status
```

Expected Output

```text
nothing to commit, working tree clean
```

---

## 19. Update .gitignore (if backup files exist)

Example

```text
*.orig
```

Commit if modified.

---

## 20. List Branches

```bash
git branch
```

---

## 21. Delete the Merged Branch

```bash
git branch -d GitWork
```

Deletes the feature branch safely.

---

## 22. View Final Commit Graph

```bash
git log --oneline --graph --decorate
```

Shows the completed merge history.

---

# Concepts Learned

## What is a Merge Conflict?

A merge conflict occurs when Git cannot automatically determine how to combine changes made independently in different branches.

Git pauses the merge and asks the developer to choose the correct version.

---

## Why Merge Conflicts Occur

Merge conflicts usually occur when:

- Two branches modify the same file.
- The same section (or line) is modified differently.
- Both branches add a file with the same name but different contents.
- One branch deletes a file while another modifies it.

---

## The Common Ancestor

Every merge begins from a common ancestor.

Example

```text
          GitWork
             D
            /
A ---- B ---- C
            \
             E
           main
```

Git compares:

- Common Ancestor (C)
- Main (E)
- GitWork (D)

If both branches modify the same content differently, Git cannot safely merge them automatically.

---

## Three-Way Merge

Git performs a Three-Way Merge using:

1. Common Ancestor
2. Current Branch
3. Incoming Branch

If changes do not overlap, Git merges automatically.

If they overlap, a conflict occurs.

---

## Conflict Markers

Git inserts temporary markers into the file.

```text
<<<<<<< HEAD
```

Beginning of the current branch.

---

```text
=======
```

Separator.

---

```text
>>>>>>> GitWork
```

End of the incoming branch.

These markers must be removed after resolving the conflict.

---

## HEAD

HEAD is Git's special pointer that represents what is currently checked out.

Normally,

```text
HEAD
 │
 ▼
main
```

or

```text
HEAD
 │
 ▼
GitWork
```

HEAD always represents the branch currently being worked on.

---

## Current Change vs Incoming Change

When executing

```bash
git merge GitWork
```

while on `main`:

Current Change = main (HEAD)

Incoming Change = GitWork

If the merge is performed in the opposite direction:

```bash
git switch GitWork
git merge main
```

then:

Current Change = GitWork

Incoming Change = main

---

## Merge Commit

A merge commit has two parent commits.

Example

```text
          D
         /
A --- B --- C
         \
          E

           \
            M
```

Unlike a normal commit, Merge Commit records the integration of two branches.

---

## Branch Deletion

Deleting a merged branch does not delete its commits.

The commits already exist inside the main branch after merging.

---

# Workflow

```text
main
 │
 │
 ├───────────────┐
 │               │
 ▼               ▼
GitWork        main

hello.xml      hello.xml

Different      Different
Content        Content

       │
       ▼

git merge GitWork

       │

Merge Conflict

       │

Manual Resolution

       │

git add

       │

git commit

       │

Merge Commit

       │

Delete Branch
```

---

# Repository Structure

```text
GitDemo/
│
├── .git/
├── welcome.txt
├── branch.txt
├── hello.xml
├── .gitignore
└── README.md
```

---

# Summary

This exercise introduced one of Git's most important concepts: Merge Conflict Resolution.

The concepts learned include:

- Feature branches
- Independent development
- Merge conflicts
- Three-way merge
- Common ancestor
- Conflict markers
- HEAD
- Current vs Incoming changes
- Manual conflict resolution
- Merge commit
- Branch deletion

Understanding merge conflicts is essential for collaborative software development because multiple developers often modify the same project simultaneously.