package com.example.healthcareclientfirebase;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class healthArticleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_health_article);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Sample data
        List<Article> articles = new ArrayList<>();
        // Example articles with image resource IDs
        articles.add(new Article("The Importance of Regular Exercise", "1. Physical Health Benefits: Regular exercise offers numerous benefits for physical health. It helps maintain a healthy weight by burning calories and building muscle mass. Exercise also improves cardiovascular health by strengthening the heart and lowering blood pressure and cholesterol levels. Additionally, it enhances immune function, reducing the risk of chronic diseases such as heart disease, type 2 diabetes, and certain types of cancer.\n" +
                "\n 2. Mental Health Benefits: Exercise has a positive impact on mental health and emotional well-being. It releases endorphins, neurotransmitters that promote feelings of happiness and reduce stress, anxiety, and depression. Regular physical activity can also improve sleep quality, boost self-esteem, and enhance cognitive function, including memory and concentration.\n" +
                "\n 3. Longevity and Quality of Life: Engaging in regular exercise is associated with increased longevity and a higher quality of life. Studies have shown that physically active individuals tend to live longer and experience fewer age-related health problems. Exercise helps maintain mobility and independence as we age, allowing us to enjoy a higher level of function and vitality.\n" +
                "\n 4. Improved Energy Levels: Contrary to popular belief, regular exercise actually boosts energy levels rather than depleting them. Physical activity increases blood flow and oxygen delivery to tissues, providing a natural energy boost. Regular exercisers often report feeling more alert, focused, and productive throughout the day.\n" +
                "\n 5. Disease Prevention and Management: Exercise plays a key role in preventing and managing various chronic diseases and health conditions. It helps control blood sugar levels in individuals with diabetes, reduces the risk of osteoporosis by strengthening bones, and alleviates symptoms of arthritis by improving joint function and flexibility. Regular physical activity also supports respiratory health and can reduce the risk of developing respiratory illnesses.\n" +
                "\n 6. Social Connection and Community: Exercise provides opportunities for social interaction and connection, whether through group fitness classes, team sports, or outdoor activities with friends and family. Building relationships and a sense of community through physical activity can enhance social well-being and overall satisfaction with life.\n" +
                "\n Overall, regular exercise is essential for maintaining optimal health and well-being. Incorporating physical activity into your daily routine can have a profound impact on both your physical and mental health, leading to a happier, healthier, and more fulfilling life.\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n", R.drawable.exercise));
        articles.add(new Article("Nutrition and Wellness", "1. Essential Nutrients: Nutrition is about providing the body with the essential nutrients it needs to function optimally. These nutrients include carbohydrates, proteins, fats, vitamins, minerals, and water. Each nutrient plays a unique role in supporting various bodily functions, from providing energy and building tissues to regulating metabolism and supporting immune function.\n" +
                "\n 2. Balanced Diet: A balanced diet is key to achieving optimal nutrition and wellness. This involves consuming a variety of foods from all food groups in appropriate proportions. Emphasizing whole, minimally processed foods such as fruits, vegetables, whole grains, lean proteins, and healthy fats ensures a diverse intake of nutrients and promotes overall health.\n" +
                "\n 3. Healthy Eating Patterns: In addition to individual nutrients, healthy eating patterns are important for overall wellness. This includes practices such as mindful eating, portion control, and moderation. Paying attention to hunger and fullness cues, enjoying meals without distractions, and savoring the flavors and textures of food can enhance the eating experience and promote better digestion and nutrient absorption.\n" +
                "\n 4. Disease Prevention and Management: Nutrition plays a crucial role in preventing and managing various chronic diseases and health conditions. A balanced diet rich in fruits, vegetables, whole grains, and lean proteins can help reduce the risk of heart disease, diabetes, obesity, and certain types of cancer. Specific nutrients, such as fiber, omega-3 fatty acids, and antioxidants, have been shown to have protective effects against inflammation and oxidative stress.\n" +
                "\n 5. Gut Health: The gut microbiome, composed of trillions of microorganisms living in the digestive tract, plays a vital role in overall health and wellness. A balanced diet that includes fiber-rich foods, fermented foods, and prebiotics and probiotics supports a healthy gut microbiome, which is associated with better digestion, immune function, and mental health.\n" +
                "\n 6. Mind-Body Connection: Nutrition and wellness are closely linked to mental and emotional well-being. Certain nutrients, such as omega-3 fatty acids and B vitamins, are important for brain health and cognitive function. Eating a balanced diet can help stabilize mood, reduce stress and anxiety, and improve overall mental clarity and focus.\n" +
                "\n 7. Lifestyle Factors: Nutrition is just one aspect of overall wellness, which also encompasses physical activity, sleep, stress management, and social connection. Adopting a holistic approach to wellness that addresses all these factors contributes to a balanced and fulfilling life.\n" +
                "By focusing on nutrition and wellness, individuals can cultivate healthy eating habits, support their body's natural functions, and enhance their overall quality of life. It's important to prioritize nourishing the body with nutrient-dense foods and adopting sustainable lifestyle practices that promote long-term health and well-being.", R.drawable.nutrition));



        articles.add(new Article("Managing Stress for Better Health", "1. Understanding Stress: Stress is the body's natural response to perceived threats or challenges, known as the fight-or-flight response. While acute stress can be beneficial in certain situations, chronic stress, which occurs over a prolonged period, can lead to negative health outcomes. Chronic stress has been linked to an increased risk of heart disease, obesity, diabetes, depression, anxiety, and other health problems.\n" +
                "2. Stress Management Techniques: There are various techniques and strategies that can help individuals manage stress effectively:\n" +
                "\n Mindfulness and Meditation: Mindfulness practices, such as meditation, deep breathing exercises, and progressive muscle relaxation, promote relaxation and reduce the body's stress response.\n" +
                "\n Physical Activity: Regular exercise is a powerful stress reliever, as it releases endorphins, neurotransmitters that promote feelings of well-being, and reduces levels of stress hormones like cortisol.\n" +
                "\n Healthy Lifestyle Habits: Adopting healthy lifestyle habits, such as getting adequate sleep, eating a balanced diet, staying hydrated, and avoiding excessive caffeine and alcohol, supports the body's ability to cope with stress.\n" +
                "\n Time Management: Effective time management techniques, such as prioritizing tasks, setting boundaries, and practicing time-blocking, can help reduce feelings of overwhelm and prevent stress from accumulating.\n" +
                "\n Social Support: Maintaining strong social connections and seeking support from friends, family, or a support group can provide emotional support and perspective during stressful times.\n" +
                "\n Cognitive Behavioral Therapy (CBT): CBT is a type of psychotherapy that helps individuals identify and change negative thought patterns and behaviors that contribute to stress and anxiety.\n" +
                "\n 3. Effects on Physical Health: Managing stress has a positive impact on physical health by reducing the risk of stress-related illnesses and improving overall well-being. Chronic stress can weaken the immune system, increase inflammation, and disrupt sleep patterns, whereas effective stress management techniques support immune function, reduce inflammation, and promote restorative sleep.\n" +
                "\n 4. Effects on Mental Health: Stress management is also essential for maintaining mental health and emotional well-being. Chronic stress is a significant risk factor for developing anxiety, depression, and other mental health disorders. By learning to manage stress effectively, individuals can improve their mood, increase resilience to life's challenges, and enhance overall psychological functioning.\n" +
                "\n 5. Holistic Approach to Stress Management: Taking a holistic approach to stress management involves addressing physical, mental, emotional, and spiritual aspects of well-being. This may include incorporating relaxation techniques, engaging in enjoyable activities, nurturing relationships, and finding meaning and purpose in life.\n" +
                "Overall, managing stress is critical for promoting better health and quality of life. By adopting healthy coping strategies and lifestyle habits, individuals can build resilience, reduce the negative effects of stress, and cultivate a greater sense of balance and well-being in their lives.", R.drawable.betterhealth));

        articles.add(new Article("Understanding Mental Health", "1. Definition of Mental Health: Mental health refers to a person's emotional, psychological, and social well-being. It encompasses how individuals think, feel, and behave, as well as their ability to cope with life's stressors, build and maintain relationships, and function effectively in daily activities.\n" +
                "\n 2. Factors Influencing Mental Health: Mental health is influenced by a complex interplay of genetic, biological, environmental, and psychosocial factors. Life experiences, such as trauma, abuse, loss, and chronic stress, can impact mental health, as can biological factors like brain chemistry and genetics.\n" +
                "\n 3. Common Mental Health Disorders: There are various mental health disorders that can affect individuals of all ages and backgrounds. Some common mental health disorders include:\n" +
                "Anxiety Disorders: Characterized by excessive worry, fear, or apprehension, including generalized anxiety disorder, panic disorder, phobias, and social anxiety disorder.\n" +
                "Mood Disorders: Disorders that affect mood and emotions, such as depression, bipolar disorder, and seasonal affective disorder.\n" +
                "Psychotic Disorders: Disorders that cause abnormal thinking and perceptions, such as schizophrenia and schizoaffective disorder.\n" +
                "Eating Disorders: Disorders characterized by abnormal eating habits and body image issues, including anorexia nervosa, bulimia nervosa, and binge-eating disorder.\n" +
                "Substance Use Disorders: Disorders involving the misuse of alcohol, drugs, or other substances, leading to significant impairment or distress.\n" +
                "\n 4. Stigma and Discrimination: Mental health stigma refers to negative attitudes, beliefs, and stereotypes surrounding mental illness. Stigma can lead to discrimination, social isolation, and barriers to seeking help and accessing treatment. Challenging stigma and promoting mental health awareness are crucial for creating supportive and inclusive communities.\n" +
                "\n 5. Importance of Early Intervention and Treatment: Early identification and intervention are key to effectively managing mental health disorders and preventing long-term negative outcomes. Treatment options may include psychotherapy, medication, support groups, lifestyle changes, and holistic approaches to wellness.\n" +
                "\n 6. Promoting Mental Health and Well-Being: Promoting mental health involves creating environments that support positive mental health outcomes and empower individuals to thrive. This includes fostering supportive relationships, building resilience, practicing self-care, promoting work-life balance, and reducing stressors and risk factors.\n" +
                "\n 7. Addressing Mental Health Disparities: Mental health disparities exist across different populations, including racial and ethnic minorities, LGBTQ+ individuals, low-income communities, and rural populations. Addressing these disparities requires culturally competent care, equitable access to resources, and policies that promote social justice and equity.\n" +
                "\n 8. Suicide Prevention: Suicide is a significant public health concern and a leading cause of death worldwide. Suicide prevention efforts focus on raising awareness, reducing stigma, promoting help-seeking behaviors, and providing support and resources to individuals in crisis.\n" +
                "\n Understanding mental health involves recognizing the complexity of mental illness, promoting empathy and compassion, and advocating for policies and practices that support mental health and well-being for all individuals. By fostering a greater understanding of mental health, we can create communities that are supportive, inclusive, and resilient.\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n", R.drawable.mentalhealth));

        articles.add(new Article("Sleep Hygiene and Its Impact on Health", "1. Understanding Sleep: Sleep is a natural and essential physiological process that allows the body and mind to rest, repair, and recharge. It is characterized by cycles of non-REM (rapid eye movement) and REM sleep stages, each serving different functions in promoting physical and mental health.\n" +
                "\n 2. Components of Sleep Hygiene: Sleep hygiene encompasses a variety of practices and habits that support healthy sleep, including:\n" +
                "Maintaining a Consistent Sleep Schedule: Going to bed and waking up at the same time every day, even on weekends, helps regulate the body's internal clock and promotes a regular sleep-wake cycle.\n" +
                "Creating a Restful Sleep Environment: Designing a sleep-friendly environment that is cool, dark, quiet, and comfortable can enhance sleep quality and promote relaxation.\n" +
                "Limiting Stimulants and Distractions: Avoiding stimulants such as caffeine and nicotine, as well as electronic devices with screens (e.g., smartphones, computers, TVs), close to bedtime can help signal the body that it's time to wind down and prepare for sleep.\n" +
                "Establishing a Relaxing Bedtime Routine: Engaging in relaxing activities before bedtime, such as reading, taking a warm bath, practicing relaxation techniques (e.g., deep breathing, meditation), or gentle stretching, can help signal to the body that it's time to sleep.\n" +
                "Managing Stress and Anxiety: Developing effective stress management strategies, such as journaling, practicing mindfulness, or seeking professional support, can help alleviate anxiety and promote better sleep.\n" +
                "\n 3. Impact on Physical Health: Good sleep hygiene is associated with numerous physical health benefits, including:\n" +
                "Improved Immune Function: Adequate sleep supports immune function, reducing the risk of infections and illness.\n" +
                "Healthy Weight Management: Poor sleep hygiene is linked to weight gain and obesity, as disrupted sleep patterns can affect hormones that regulate appetite and metabolism.\n" +
                "Reduced Risk of Chronic Disease: Quality sleep is associated with a lower risk of chronic diseases such as heart disease, diabetes, and hypertension.\n" +
                "\n 4. Impact on Mental Health: Sleep hygiene also has significant effects on mental and emotional well-being, including:\n" +
                "Enhanced Mood and Emotional Regulation: Quality sleep promotes emotional stability, resilience, and the ability to cope with stressors.\n" +
                "Improved Cognitive Function: Adequate sleep is essential for cognitive processes such as memory consolidation, problem-solving, decision-making, and creativity.\n" +
                "\n 5. Overall Well-Being: Prioritizing good sleep hygiene contributes to overall health and well-being by supporting physical vitality, mental clarity, emotional resilience, and a higher quality of life.\n" +
                "In summary, practicing good sleep hygiene is essential for promoting optimal health and well-being. By incorporating healthy sleep habits into daily routines, individuals can improve sleep quality, enhance physical and mental functioning, and enjoy the many benefits of restorative sleep.", R.drawable.impactonhealth));

        articles.add(new Article("The Benefits of Mind-Body Practices", "1. Stress Reduction: Mind-body practices are highly effective in reducing stress and promoting relaxation. Techniques such as meditation, deep breathing exercises, and progressive muscle relaxation activate the body's relaxation response, counteracting the effects of the stress response and promoting a sense of calm and tranquility.\n" +
                "\n 2. Improved Mental Health: Mind-body practices have been shown to have significant benefits for mental health and emotional well-being. Regular practice can help reduce symptoms of anxiety, depression, and other mood disorders by promoting emotional regulation, enhancing self-awareness, and cultivating a positive mindset.\n" +
                "\n 3. Enhanced Physical Health: Mind-body practices have positive effects on physical health, including:\n" +
                "Improved Cardiovascular Health: Practices such as meditation and deep breathing can lower blood pressure, reduce heart rate, and improve overall cardiovascular function.\n" +
                "Pain Management: Mind-body practices, including mindfulness meditation, yoga, and tai chi, have been shown to reduce chronic pain and improve pain tolerance by altering pain perception and enhancing coping mechanisms.\n" +
                "Boosted Immune Function: Mind-body practices support immune function by reducing inflammation, enhancing immune response, and promoting overall health and vitality.\n" +
                "\n 4. Better Sleep Quality: Mind-body practices can improve sleep quality and promote restful sleep by reducing stress and anxiety, calming the mind, and promoting relaxation. Practices such as mindfulness meditation and relaxation techniques can help individuals fall asleep faster, stay asleep longer, and wake up feeling refreshed.\n" +
                "\n 5. Increased Resilience and Coping Skills: Engaging in mind-body practices cultivates resilience and enhances coping skills, enabling individuals to better navigate life's challenges and adversities. Mindfulness practices, in particular, teach individuals to approach difficult emotions and situations with greater equanimity and acceptance.\n" +
                "\n 6. Enhanced Cognitive Function: Mind-body practices have been shown to improve cognitive function, including memory, attention, and concentration. Regular practice can enhance brain health, promote neuroplasticity, and protect against age-related cognitive decline.\n" +
                "\n 7. Promotion of Mindfulness and Presence: Mind-body practices foster mindfulness, the practice of paying attention to the present moment with openness, curiosity, and acceptance. Mindfulness enhances self-awareness, promotes a deeper connection with oneself and others, and cultivates a sense of meaning and purpose in life.\n" +
                "\n 8. Improved Quality of Life: Ultimately, mind-body practices contribute to a higher quality of life by promoting holistic health and well-being. They empower individuals to take an active role in their health and healing, enhance self-care practices, and cultivate a greater sense of balance, vitality, and joy in daily life.\n" +
                "\n In summary, mind-body practices offer a wide range of benefits for physical, mental, and emotional health. By incorporating these practices into daily routines, individuals can enhance their overall well-being, resilience, and quality of life.", R.drawable.mindbodypractices));

        articles.add(new Article("Women's Health Issues", "1. Reproductive Health: Reproductive health concerns include menstrual health, fertility, pregnancy, childbirth, and menopause. Common issues include menstrual irregularities, polycystic ovary syndrome (PCOS), endometriosis, infertility, pregnancy complications, and symptoms associated with menopause, such as hot flashes and vaginal dryness.\n" +
                "\n 2. Breast Health: Breast health is a significant concern for women, as breast cancer is one of the most common cancers among women worldwide. Regular breast self-exams, clinical breast exams, and mammograms are essential for early detection and treatment of breast cancer. Additionally, women may experience other breast-related issues such as fibrocystic breast changes, breast pain, and breast infections.\n" +
                "\n 3. Cardiovascular Health: Heart disease is the leading cause of death among women globally, yet it is often underdiagnosed and undertreated in women compared to men. Risk factors for heart disease in women include high blood pressure, high cholesterol, diabetes, obesity, physical inactivity, smoking, and stress. Promoting cardiovascular health through healthy lifestyle habits, regular exercise, and preventive screenings is essential for women's overall well-being.\n" +
                "\n 4. Mental Health: Women are disproportionately affected by mental health disorders such as depression, anxiety, and eating disorders. Hormonal fluctuations, life transitions, social and cultural factors, trauma, and gender-based violence contribute to women's mental health challenges. Access to mental health services, support networks, and self-care practices are crucial for addressing women's mental health needs.\n" +
                "\n 5. Sexual and Reproductive Rights: Women's sexual and reproductive rights encompass access to comprehensive sexual health education, contraception, family planning services, safe and legal abortion, and reproductive healthcare. Ensuring women's autonomy and decision-making power over their bodies and reproductive choices is essential for promoting gender equality and women's health.\n" +
                "\n 6. Cancer Screening and Prevention: In addition to breast cancer screening, women should undergo regular screenings for cervical cancer (Pap smear), ovarian cancer (transvaginal ultrasound and CA-125 blood test), and colorectal cancer (colonoscopy). Preventive measures such as HPV vaccination and lifestyle modifications can help reduce the risk of certain cancers.\n" +
                "\n 7. Bone Health: Osteoporosis, a condition characterized by weakened bones, is more prevalent in women, especially after menopause. Adequate calcium and vitamin D intake, weight-bearing exercise, and lifestyle modifications can help maintain bone health and reduce the risk of fractures.\n" +
                "\n 8. Intimate Partner Violence: Intimate partner violence (IPV) is a significant public health issue that disproportionately affects women. IPV includes physical, sexual, emotional, and economic abuse by a current or former intimate partner. Access to support services, shelters, legal assistance, and community resources is critical for survivors of IPV.\n" +
                "\n 9. Gender-Based Disparities in Healthcare: Women often face gender-based disparities in healthcare, including diagnostic delays, misdiagnosis, inadequate treatment, and lack of access to quality care. Addressing gender biases and advocating for equitable healthcare policies and practices are essential for promoting women's health equity.\n" +
                "Overall, addressing women's health issues requires a comprehensive approach that addresses biological, social, cultural, and structural factors influencing women's health and well-being. By prioritizing women's health needs and promoting gender-responsive healthcare, we can improve outcomes and enhance the quality of life for women worldwide.", R.drawable.healthissues));
// Assume R.drawable.image1 and R.drawable.image2 are valid drawable resources

        // Add more articles as needed

        ArticleAdapter adapter = new ArticleAdapter(this, articles);
        recyclerView.setAdapter(adapter);
    }
}