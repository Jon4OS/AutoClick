# AutoClick for Fabric

AutoClick is a automatic clicker that is integrated into Minecraft. Right now it is fairly new, fairly basic and only has a single function - it attacks any entity in your crosshair every time your weapon cooldown runs out.

While it is inspired by tools like [AutoHotKey] and intended for AFKing at mob farms or similar, some may consider it closer to something like a KillAura cheat (see the note on cheating below).

## Setup
After installing Fabric, download the AutoClick jar from the [Releases tab][Releases]and copy it into your mods folder. You will also need to have Fabric API in your mods folder as this mod depends on it.

## Setup for development
Run the following command:

```
./gradlew idea genSources
```

- Open with **Intellij** IDEA
- Select a **JDK**/SDK
- Edit the **Run Configurations** "use classpath of module" from `AutoClick` to `Autoclick.main`

## Building 
Run the `remapJar` task to generate a jar that can be used by Fabric Loader. It will be located in `build/libs/`.

## License

This tool is available under the [MIT license].

## A note on cheating
This mod is intended to aid AFKing, inspired by external probrams like [AutoHotKey] and [AutoKey], it is intended to provide an in-game alternative that works with alt-tabbing and on all Operating Systems.

Due to the nature of this mod, it could easily be used to gain an advantage in PvP or PvE. Even AFKing or AFKing with the help of mods/tools may be considered cheating by some. This can be very subjective and opinions differ. Therefore I advise you to consult the rules of your server before using this mod.

I am not responsible for you getting banned or anything else that may come from using this mod.

[Releases]: https://github.com/LeafHacker/AutoClick/releases
[AutoHotKey]: https://www.autohotkey.com
[AutoKey]: https://github.com/autokey/autokey
[MIT license]: /LICENSE