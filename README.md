# Passing Parcelables in Compose Navigation
*by Ioannis Anifantakis*

This project demonstrates how to pass Parcelables using the Jetpack Compose Navigation Component using an old hack through the BackStack entry and with the new Type Safety via DataClasses as of in version 2.8.0-alpha08 of the Navigation Component.

## Project Branches
1. [Old hack using BackStack entry to pass Parcelables](https://github.com/ioannisa/TypeSafeComposeNavigation/tree/1.Nav-Parcelables-by-BackStackEntry-SavedStateHandle)
2. [New type-safety approach using DataClasses to pass Parcelables](https://github.com/ioannisa/TypeSafeComposeNavigation/tree/2.Nav-Parcelables-by-TypeSafety)
3. [New type-safety approach using DataClasses and Helper-Library to pass Parcelables](https://github.com/ioannisa/TypeSafeComposeNavigation/tree/3.Type-Safe-helper-library)

## Related GISTS
1. [Old hack using BackStack entry to pass Parcelables](https://gist.github.com/ioannisa/2f674098e20da5f0ef0747b529b129a6)
2. [New type-safety approach using DataClasses to pass Parcelables](https://gist.github.com/ioannisa/924e256e10bbb40148f96cc5c8c03daf)

## Custom Helper Library for the Type-Safety approach
You can make use of a library to help you simplify the process of passing parcelables using DataClasses with the new Type-Safety approach [here](https://github.com/ioannisa/NavTypeParcelableHelperLibrary)
