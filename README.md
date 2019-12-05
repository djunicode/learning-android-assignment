# Music Finder
3rd Assignment for DJUnicode Android Team 2019-20
This will be referred to as the base repo or the base fork
Forking it to your account will make a head 

### Steps to follow:
1. Fork this repo to your account (make a head fork)
2. Clone the forked repo and make your changes
3. Commit and push the changes to your repo
4. Create a pull request
5. After your pull request is merged, your changes are now reflected in the base fork

### Keeping all Head Forks in Sync
It may happen that some of the code you need is written by someone else but you don't have it in your repo.
Avoid working on the same file at a same time to prevent merge conflicts. (Conflicts that are caused by different code in the same file)
Use these steps to intialize:
1. Add another remote url `upstream` using the command: `git remote add upstream <URL OF THE BASE FORK HERE>`
2. Verify that you have two remotes, upstream and origin using `git remote -v`
<br>
Before making changes to the code repeat these steps to be in sync:
1. You have to fetch the changes in the base fork.
2. Run command `git pull upstream <BRANCH NAME>`
3. Make changes, commit and push
4. Submit a pull request, You don't have to delete the head forks and local repos on your machine