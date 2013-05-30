speclj-growl-like-notifier
==========================

Very raw, just for my needs.

Why
---
I'd like to be notified when speclj fails.

Requirements
------------
OSX with *terminal-notifier* (you can get it via *gem install terminal-notifier*). 

If you'd can easily use other utils to get notification, change the code. 

How
---
1. Add speclj folder into classpath (or just copy into 'spec' dir)
2. Run *lein spec -a -f osx-notify*
