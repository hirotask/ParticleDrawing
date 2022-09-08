# ParticleDrawing

This is Minecraft plugin which can draw complex curves with particles.

## For developers

### Maven

1. Add Repository

### Gradle

1. Add Repository

```groovy
maven {
    name = "GitHubPackages"
    url = uri("https://maven.pkg.github.com/hirotask/ParticleDrawing")
    credentials {
        username = USERNAME // GitHubのユーザ名
        password = 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
    }
}

```

2. Add Dependency
```groovy
dependencies {
    ...
    // 公開したライブラリをimplementationに追加
    implementation 'tech.erudo.mc.practice.particledrawing.particle-drawing:v1.0-SNAPSHOT'
}
```