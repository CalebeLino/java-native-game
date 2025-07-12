## [0.2.0-PREVIEW] - 2025-07-11

### Added

- Support for generic game Attribute<T> publishing and recover;
- AttributeSharer helper methods for better code reading;
- AttributeNotFoundException as a hint to which attribute was laking when the sharing occurred;
- Tests for AttributeSharer.

## [0.1.1-PREVIEW] - 2025-07-10

### Added

- Prototype for engine testing infrastructure;
- First test for CycleManager class.

### Changed

- Map of shared attributes now keeps attributes in a String-Instance Map, such as the AttributeHolder class, so there is no conversion overhead.

## [0.1.0-PREVIEW] - 2025-07-09

### Added

- Dagger injection logic into attribute sharing, that will be this game engine's way to GameObjects-Script;
- Script and GameObject's prototype;
- Engine folder structure;
- EngineComponent and CycleManager;
- Calebe's happy summer (or winter :D).