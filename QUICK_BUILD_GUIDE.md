# طريقة سريعة للحصول على ملف JAR

## الحل الأسهل: استخدام GitHub Actions

سأقوم بإعداد المشروع ليتم بناؤه تلقائياً عبر GitHub.

### الخطوات:

1. **إنشاء حساب GitHub** (إذا لم يكن لديك)
   - اذهب إلى https://github.com
   - سجل حساب مجاني

2. **إنشاء Repository جديد**
   - اضغط على "+" في أعلى اليمين
   - اختر "New repository"
   - سمّه "CustomArmorPlugin"
   - اجعله Public
   - اضغط "Create repository"

3. **رفع الملفات**
   - بعد إنشاء الـ repository، اضغط "uploading an existing file"
   - اسحب كل الملفات من مجلد `CustomArmorPlugin` وأسقطها هناك
   - اضغط "Commit changes"

4. **طلب مني بناء المشروع**
   - أخبرني عندما تنتهي من رفع الملفات
   - سأقوم بإعداد GitHub Actions لبناء المشروع تلقائياً
   - ستحصل على ملف JAR جاهز للتحميل

---

## الحل البديل: استخدام IntelliJ IDEA

### التحميل:
1. اذهب إلى https://www.jetbrains.com/idea/download/
2. حمل "Community Edition" (مجاني)
3. ثبّت البرنامج

### البناء:
1. افتح IntelliJ IDEA
2. اختر "Open"
3. اختر مجلد `CustomArmorPlugin`
4. انتظر حتى ينتهي من تحميل المكتبات
5. على اليمين، اضغط على "Maven"
6. اضغط على "Lifecycle" ثم "package"
7. انتظر حتى ينتهي البناء
8. ستجد ملف JAR في مجلد `target`

---

## أيهما تفضل؟

- **GitHub Actions**: أسهل، لكن يحتاج إنشاء حساب GitHub ورفع الملفات
- **IntelliJ IDEA**: أسرع، لكن يحتاج تحميل وتثبيت برنامج

أخبرني أي طريقة تفضل وسأساعدك خطوة بخطوة.
