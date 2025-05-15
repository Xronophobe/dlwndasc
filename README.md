### What's this

This project is an attempt to trace down the issue in a proprietary Android application, where the deep linking fails to find the appropriate route,
even though the correct path is clearly set as it can be verified by inspecting:

`navController > _graph > nodes > values`.

### TODO

- [x] create two destinations
- [x] add a deep link to one of them
- [x] add a navigation drawer, wrapping the NavHost
- [x] use dashes in the deep link
- [ ] add a splash screen with conditional navigation callbacks


### I don't want to type this every time and I'm not writing a Makefile for just one command:

```
adb shell am start -a android.intent.action.VIEW -d "dlwndasc://linked-items/foobar" com.xronophobe.dlwndasc
```
