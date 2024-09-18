# Reproduction of kotlinc crash

1. `./gradlew compileDebugUnitTestKotlin`

## Expected

Success

## Actual

```
> Task :lib:compileDebugUnitTestKotlin FAILED
e: org.jetbrains.kotlin.backend.common.BackendException: Backend Internal error: Exception during IR lowering
File being compiled: /usr/local/google/home/aurimas/Code/kotlinccrash/lib/src/test/java/com/example/kotlinccrash/ExampleUnitTest.kt
The root cause java.lang.RuntimeException was thrown at: org.jetbrains.kotlin.backend.jvm.codegen.FunctionCodegen.generate(FunctionCodegen.kt:48)
        at org.jetbrains.kotlin.backend.common.CodegenUtil.reportBackendException(CodegenUtil.kt:253)
        at org.jetbrains.kotlin.backend.common.CodegenUtil.reportBackendException$default(CodegenUtil.kt:236)
        at org.jetbrains.kotlin.backend.common.phaser.PerformByIrFilePhase.invokeSequential(performByIrFile.kt:66)
        at org.jetbrains.kotlin.backend.common.phaser.PerformByIrFilePhase.invoke(performByIrFile.kt:53)
        at org.jetbrains.kotlin.backend.common.phaser.PerformByIrFilePhase.invoke(performByIrFile.kt:39)
        at org.jetbrains.kotlin.backend.common.phaser.NamedCompilerPhase.phaseBody(CompilerPhase.kt:166)
        at org.jetbrains.kotlin.backend.common.phaser.AbstractNamedCompilerPhase.invoke(CompilerPhase.kt:113)
        at org.jetbrains.kotlin.backend.common.phaser.CompositePhase.invoke(PhaseBuilders.kt:27)
        at org.jetbrains.kotlin.backend.common.phaser.CompositePhase.invoke(PhaseBuilders.kt:14)
        at org.jetbrains.kotlin.backend.common.phaser.NamedCompilerPhase.phaseBody(CompilerPhase.kt:166)
        at org.jetbrains.kotlin.backend.common.phaser.AbstractNamedCompilerPhase.invoke(CompilerPhase.kt:113)
        at org.jetbrains.kotlin.backend.common.phaser.CompilerPhaseKt.invokeToplevel(CompilerPhase.kt:62)
        at org.jetbrains.kotlin.backend.jvm.JvmIrCodegenFactory.invokeCodegen(JvmIrCodegenFactory.kt:371)
        at org.jetbrains.kotlin.cli.jvm.compiler.KotlinToJVMBytecodeCompiler.runCodegen(KotlinToJVMBytecodeCompiler.kt:469)
        at org.jetbrains.kotlin.cli.jvm.compiler.KotlinToJVMBytecodeCompiler.compileModules$cli(KotlinToJVMBytecodeCompiler.kt:138)
        at org.jetbrains.kotlin.cli.jvm.K2JVMCompiler.doExecute(K2JVMCompiler.kt:170)
        at org.jetbrains.kotlin.cli.jvm.K2JVMCompiler.doExecute(K2JVMCompiler.kt:43)
        at org.jetbrains.kotlin.cli.common.CLICompiler.execImpl(CLICompiler.kt:102)
        at org.jetbrains.kotlin.cli.common.CLICompiler.exec(CLICompiler.kt:316)
        at org.jetbrains.kotlin.incremental.IncrementalJvmCompilerRunner.runCompiler(IncrementalJvmCompilerRunner.kt:464)
        at org.jetbrains.kotlin.incremental.IncrementalJvmCompilerRunner.runCompiler(IncrementalJvmCompilerRunner.kt:73)
        at org.jetbrains.kotlin.incremental.IncrementalCompilerRunner.doCompile(IncrementalCompilerRunner.kt:506)
        at org.jetbrains.kotlin.incremental.IncrementalCompilerRunner.compileImpl(IncrementalCompilerRunner.kt:423)
        at org.jetbrains.kotlin.incremental.IncrementalCompilerRunner.compileNonIncrementally(IncrementalCompilerRunner.kt:301)
        at org.jetbrains.kotlin.incremental.IncrementalCompilerRunner.compile(IncrementalCompilerRunner.kt:129)
        at org.jetbrains.kotlin.daemon.CompileServiceImplBase.execIncrementalCompiler(CompileServiceImpl.kt:674)
        at org.jetbrains.kotlin.daemon.CompileServiceImplBase.access$execIncrementalCompiler(CompileServiceImpl.kt:91)
        at org.jetbrains.kotlin.daemon.CompileServiceImpl.compile(CompileServiceImpl.kt:1659)
        at java.base/jdk.internal.reflect.DirectMethodHandleAccessor.invoke(DirectMethodHandleAccessor.java:103)
        at java.base/java.lang.reflect.Method.invoke(Method.java:580)
        at java.rmi/sun.rmi.server.UnicastServerRef.dispatch(UnicastServerRef.java:360)
        at java.rmi/sun.rmi.transport.Transport$1.run(Transport.java:200)
        at java.rmi/sun.rmi.transport.Transport$1.run(Transport.java:197)
        at java.base/java.security.AccessController.doPrivileged(AccessController.java:714)
        at java.rmi/sun.rmi.transport.Transport.serviceCall(Transport.java:196)
        at java.rmi/sun.rmi.transport.tcp.TCPTransport.handleMessages(TCPTransport.java:598)
        at java.rmi/sun.rmi.transport.tcp.TCPTransport$ConnectionHandler.run0(TCPTransport.java:844)
        at java.rmi/sun.rmi.transport.tcp.TCPTransport$ConnectionHandler.lambda$run$0(TCPTransport.java:721)
        at java.base/java.security.AccessController.doPrivileged(AccessController.java:400)
        at java.rmi/sun.rmi.transport.tcp.TCPTransport$ConnectionHandler.run(TCPTransport.java:720)
        at java.base/java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1144)
        at java.base/java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:642)
        at java.base/java.lang.Thread.run(Thread.java:1570)
Caused by: java.lang.RuntimeException: Exception while generating code for:
FUN name:setTextViewError_string visibility:public modality:FINAL <> ($this:com.example.kotlinccrash.ExampleUnitTest) returnType:kotlin.Unit
  $this: VALUE_PARAMETER name:<this> type:com.example.kotlinccrash.ExampleUnitTest
  BLOCK_BODY
    CALL 'public final fun setTextViewHint (viewId: kotlin.Int, hint: kotlin.CharSequence?): kotlin.Unit declared in androidx.core.widget.RemoteViewsCompat' type=kotlin.Unit origin=null
      $receiver: CONSTRUCTOR_CALL 'public constructor <init> (p0: @[FlexibleNullability] kotlin.String?, p1: kotlin.Int) declared in android.widget.RemoteViews' type=android.widget.RemoteViews origin=null
        p0: CONST String type=kotlin.String value=""
        p1: CONST Int type=kotlin.Int value=0
      viewId: CONST Int type=kotlin.Int value=0
      hint: CONST String type=kotlin.String value="Hello world"

        at org.jetbrains.kotlin.backend.jvm.codegen.FunctionCodegen.generate(FunctionCodegen.kt:48)
        at org.jetbrains.kotlin.backend.jvm.codegen.FunctionCodegen.generate$default(FunctionCodegen.kt:41)
        at org.jetbrains.kotlin.backend.jvm.codegen.ClassCodegen.generateMethodNode(ClassCodegen.kt:407)
        at org.jetbrains.kotlin.backend.jvm.codegen.ClassCodegen.generateMethod(ClassCodegen.kt:424)
        at org.jetbrains.kotlin.backend.jvm.codegen.ClassCodegen.generate(ClassCodegen.kt:169)
        at org.jetbrains.kotlin.backend.jvm.FileCodegen.lower(JvmPhases.kt:39)
        at org.jetbrains.kotlin.backend.common.phaser.PhaseFactoriesKt.createFilePhase$lambda$4(PhaseFactories.kt:71)
        at org.jetbrains.kotlin.backend.common.phaser.PhaseBuildersKt$createSimpleNamedCompilerPhase$1.phaseBody(PhaseBuilders.kt:69)
        at org.jetbrains.kotlin.backend.common.phaser.SimpleNamedCompilerPhase.phaseBody(CompilerPhase.kt:226)
        at org.jetbrains.kotlin.backend.common.phaser.AbstractNamedCompilerPhase.invoke(CompilerPhase.kt:113)
        at org.jetbrains.kotlin.backend.common.phaser.PerformByIrFilePhase.invokeSequential(performByIrFile.kt:63)
        ... 40 more
Caused by: java.lang.NullPointerException
        at org.jetbrains.kotlin.backend.jvm.codegen.ExpressionCodegen.visitCall(ExpressionCodegen.kt:605)
        at org.jetbrains.kotlin.backend.jvm.codegen.ExpressionCodegen.visitCall(ExpressionCodegen.kt:139)
        at org.jetbrains.kotlin.ir.expressions.IrCall.accept(IrCall.kt:24)
        at org.jetbrains.kotlin.backend.jvm.codegen.ExpressionCodegen.visitStatementContainer(ExpressionCodegen.kt:545)
        at org.jetbrains.kotlin.backend.jvm.codegen.ExpressionCodegen.visitBlockBody(ExpressionCodegen.kt:550)
        at org.jetbrains.kotlin.backend.jvm.codegen.ExpressionCodegen.visitBlockBody(ExpressionCodegen.kt:139)
        at org.jetbrains.kotlin.ir.expressions.IrBlockBody.accept(IrBlockBody.kt:20)
        at org.jetbrains.kotlin.backend.jvm.codegen.ExpressionCodegen.generate(ExpressionCodegen.kt:241)
        at org.jetbrains.kotlin.backend.jvm.codegen.FunctionCodegen.doGenerate(FunctionCodegen.kt:124)
        at org.jetbrains.kotlin.backend.jvm.codegen.FunctionCodegen.generate(FunctionCodegen.kt:45)
        ... 50 more
```

## Notes

Commenting out `compilerOptions.languageVersion.set(KotlinVersion.KOTLIN_1_9)` takes it pass again. 
