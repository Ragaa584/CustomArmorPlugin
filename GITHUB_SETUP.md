# خطوات رفع المشروع إلى GitHub والحصول على ملف JAR

## الخطوة 1: إنشاء Repository جديد

1. اذهب إلى https://github.com
2. اضغط على "+" في أعلى اليمين
3. اختر "New repository"
4. املأ البيانات:
   - Repository name: `CustomArmorPlugin`
   - Description: `Custom 3D Armor Plugin for Minecraft`
   - اختر: Public
   - **لا** تضع علامة على "Add a README file"
5. اضغط "Create repository"

## الخطوة 2: رفع الملفات

بعد إنشاء الـ repository، ستظهر صفحة تحتوي على أوامر.

**اختر الطريقة الثانية: "uploading an existing file"**

1. في صفحة الـ repository الجديد، اضغط على رابط "uploading an existing file"
2. اسحب كل الملفات من مجلد `CustomArmorPlugin` وأسقطها في الصفحة
3. تأكد من رفع كل الملفات:
   - `pom.xml`
   - `build.gradle`
   - `src/` folder
   - `.github/` folder
   - جميع ملفات `.md`
   - جميع ملفات `.bat`
4. في أسفل الصفحة، اكتب في "Commit changes":
   - "Initial commit"
5. اضغط "Commit changes"

## الخطوة 3: تشغيل البناء

1. بعد رفع الملفات، اذهب إلى الـ repository
2. اضغط على "Actions" في أعلى الصفحة
3. ستجد workflow اسمه "Build CustomArmorPlugin"
4. اضغط عليه
5. اضغط على "Run workflow" → "Run workflow"

## الخطوة 4: تحميل ملف JAR

1. انتظر حتى ينتهي البناء (يستغرق 2-3 دقائق)
2. عندما يظهر علامة خضراء ✓ بجانب اسم الـ workflow
3. اضغط على الـ workflow
4. في أسفل الصفحة، ستجد قسم "Artifacts"
5. اضغط على "CustomArmorPlugin-JAR"
6. سيتم تحميل ملف ZIP
7. فك الضغط من الملف ZIP
8. ستجد ملف `CustomArmorPlugin-1.0.0.jar` - هذا هو ملف البلاجين!

## الخطوة 5: استخدام البلاجين

1. انسخ ملف `CustomArmorPlugin-1.0.0.jar`
2. ضعه في `plugins` folder في سيرفر ماين كرافت
3. أعد تشغيل السيرفر
4. البلاجين جاهز للاستخدام!

---

## ملاحظات مهمة

- إذا لم يظهر "Actions" في أعلى الصفحة، انتظر دقيقة ثم حدث الصفحة
- البناء يستغرق 2-3 دقائق في المرة الأولى
- ملف JAR سيكون جاهز للاستخدام مباشرة
- لا تحتاج لتثبيت أي شيء على جهازك

---

## إذا واجهت مشكلة

- تأكد من رفع جميع الملفات
- تأكد من أن مجلد `.github/workflows/` موجود ويحتوي على `build.yml`
- أخبرني بما حدث وسأساعدك
