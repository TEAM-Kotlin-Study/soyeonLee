1. `android:textIsSelectable="true"`를 하면 텍스트창의 내용을 복사할 수 있음
2. FCM - Firebase Cloud Messaging,  무료로 메시지를 안정적으로 전송할 수 있는 교차 플랫폼 메시징 솔루션

3. https://console.firebase.google.com/ 에서 생성을 하는데, 어플을 등록할 때에는 app의 build.gradle에 있는 defaultConfig의 applicationId와 동일한 id여야 함

4. 푸시 알림에서는 SHA-1이 굳이 필요없기에 입력하지 않음![스크린샷 2022-07-07 오후 12.18.29](/Users/isoyeon/Library/Application Support/typora-user-images/스크린샷 2022-07-07 오후 12.18.29.png)

5. 강의와 fcm 문서에서는 classpath를 지정하게끔 되어있으나, classPath는 없어졌다.

   참고: https://developer.android.com/studio/releases/gradle-plugin?hl=ko#updating-plugin 

   때문에, classPath에 적인 'com.google.gms:google-services:4.3.10'을 project build gradle의 plugins에 추가

   ```bash
   // Top-level build file where you can add configuration options common to all sub-projects/modules.
   plugins {
       id 'com.android.application' version '7.1.2' apply false
       id 'com.android.library' version '7.1.2' apply false
       id 'org.jetbrains.kotlin.android' version '1.5.30' apply false
       id 'com.google.gms.google-services' version '4.3.13' apply false
   }
   
   task clean(type: Delete) {
       delete rootProject.buildDir
   }
   ```

6. https://firebase.google.com/docs/reference/fcm/rest/v1/projects.messages/send 참고
7. 