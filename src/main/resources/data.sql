use polishsite;
DELETE from users;

INSERT INTO users (id, name, surname, email, password_hash, role, is_active)
SELECT 1, 'hajar', 'nefaa', 'hajarnefaa@gmail.com', '$2a$10$4OfOn5s5Dh8XlVrI1jN0f.BX0LDb8CYsdTXSdPW.25l6KZ3K/zw3m', 'User', TRUE
WHERE NOT EXISTS (SELECT 1 FROM users WHERE id = 1);

INSERT INTO users (id, name, surname, email, password_hash, role, is_active)
SELECT 2, 'sara', 'Doe', 'sara@gmail.com', '$2a$10$4OfOn5s5Dh8XlVrI1jN0f.BX0LDb8CYsdTXSdPW.25l6KZ3K/zw3m', 'User', FALSE
WHERE NOT EXISTS (SELECT 1 FROM users WHERE id = 2);

INSERT INTO users (id, name, surname, email, password_hash, role, is_active)
values (3, 'Konstantinos', 'Hadjigregoriades', 'hadjigregoriadesc@gmail.com', '$2a$10$Nv539RSklkQW1Ncp4TdaOOE/GB0DdY4IZR6sk75oDPQwQZ784xyGq', 'Moderator', TRUE);

INSERT INTO users (id, name, surname, email, password_hash, role, is_active)
SELECT 4, 'ian', 'Cooper', 'ian@gmail.com', '$2a$10$4OfOn5s5Dh8XlVrI1jN0f.BX0LDb8CYsdTXSdPW.25l6KZ3K/zw3m', 'Admin', TRUE
WHERE NOT EXISTS (SELECT 1 FROM users WHERE id = 4);
#password for the Admin: @Hajar18

INSERT INTO users (id, name, surname, email, password_hash, role, is_active)
SELECT 5, 'zuzka', 'ludek', 'zuzka.hilton@gmail.com', '$2a$10$fN3Ln9Eq6LhO80k9AqptquSooOsROPHKFOs2cTL6jQ.q8HyJXb9Lq', 'Admin', TRUE
WHERE NOT EXISTS (SELECT 1 FROM users WHERE id = 5);
#admin password: @Zuzkaludek123

DELETE FROM news;
INSERT INTO polishsite.news (`title`, `content`, `date`, `link`, `imgUrl`) VALUES ('Test News 1', 'Blah blah blah', '2024-12-05', 'www.test.com', 'red.png');
INSERT INTO polishsite.news (`title`, `content`, `date`, `link`, `imgUrl`) VALUES ('Test News 2', 'Tra la la la', '2024-12-02', 'www.testagain.com', 'blue.png');

DELETE FROM resources;
INSERT INTO polishsite.resources (`name`, `description`, `access`, `link`, `address`, `phone`) VALUES ('Learn French', 'Pretend this is a resource without a website. The user has to go to their offices in real life to register.', 'Go to your local center and ask for more information.', NULL, '12 French Street CF00 0AA', '+44 777777777');
INSERT INTO polishsite.resources (`name`, `description`, `access`, `link`, `address`, `phone`) VALUES ('Learn English', 'This is just a long test description. Pretend you''re reading about an offer to learn english through a specific resource, maybe a course or website.', 'Sign up for a free plan on the website:', 'www.english.com', NULL, '+44 123456789');

DELETE FROM skills;
INSERT INTO polishsite.skills (`name`, `description`, `link`, `duration`, `expiryDate`) VALUES ('Skill #1', 'This is the first description.', 'www.google.com', '26', '2024-12-02');
INSERT INTO polishsite.skills (`name`, `description`, `link`, `duration`, `expiryDate`) VALUES ('Skill #2', 'This is the second description.', 'www.linkedin.com', '54', '2026-06-13');
INSERT INTO polishsite.skills (`name`, `description`, `link`, `duration`, `expiryDate`) VALUES ('Skill #3', 'This is the third description.', 'www.reddit.com', '8', '2025-01-23');

DELETE from organisations;
INSERT INTO organisations (name, description, logo) VALUES ('Cardiff Univeristy', 'An esteemed university in south wales', 'CUlogo.png');
INSERT INTO organisations (name, description, logo) VALUES ('Polish Association of South Wales', 'An organisation which promotes polish heritage', 'logo.jpg');
INSERT INTO organisations (name, description, logo) VALUES ('The Federation of Poles in Great Britain', 'An organization representing the interests of the Polish community across the UK', 'red.png');
INSERT INTO organisations (name, description, logo) VALUES ('South Wales Polish Scouts Association', 'A youth organization fostering Polish culture, values, and traditions among young people.', 'blue.png');
INSERT INTO organisations (name, description, logo) VALUES ('Cymrun Cofio', 'A group that preserves the stories of Polish veterans and their contributions to Wales', 'ORGlogo.png');
INSERT INTO organisations (name, description, logo) VALUES ('Cardiff City Council - Polish Support Services', 'A local government initiative providing practical support and guidance to the Polish community in Cardiff.', 'Council.jpg');

INSERT INTO work_information(name, description, link, job_type, expiry_date)
VALUES
    ('Software Engineer', 'Develop and maintain software applications.', 'https://example.com/software-engineer', 'Full-Time', '2024-12-31'),
    ('Data Analyst', 'Analyse and interpret complex datasets.', 'https://example.com/data-analyst', 'Part-Time', '2024-12-15');

insert into rights(title, description) values
    ('Domain 7: Rights and Responsibilities','In seeking to become a Nation of Sanctuary, as well as through implementing the Anti Racist Wales Action Plan, the Welsh Government is seeking to eliminate inequalities and support integration. For people to fully integrate with Welsh communities, they need to understand their rights and responsibilities. Host community members equally have responsibilities to follow the law, engage with democratic processes and participate in local communities. Individuals also need to be able to exercise their rights to ensure they have the safety net which is sometimes required. This is why advice services and awareness-raising activities can play a critical role in supporting integration. Awareness of rights and responsibilities will support new migrants to build social connections and awareness of Welsh systems more quickly. Rights and responsibilities establish a common framework for interactions between all individuals in a community. It is therefore important that new migrants are supported to understand these as soon as possible.\n\nAwareness of rights and responsibilities will support new migrants to build social connections and awareness of Welsh systems more quickly. Rights and responsibilities establish a common framework for interactions between all individuals in a community. It is therefore important that new migrants are supported to understand these as soon as possible.');

insert into sub_rights(sub_title,description,title_id) values
                                                           ('Indicator 1: percent registering to vote','Does data exist for UK-born individuals in Wales? Yes: Electoral statistics for the UK.
Does data exist for migrants in Wales? Yes: Overseas, anonymous, opted-out, EU citizens and Parliamentary electors by local authority.',1),
                                                           ('Indicator 2: percentage utilising advice services','Does data exist for UK-born individuals in Wales? Yes: National Survey for Wales.
Does data exist for migrants in Wales? No.

Questions asked:

In the last 12 months, have you had advice or support from any organisations in these areas of life?

Debt
Financial matters other than debt
Welfare benefits
Housing
Employment
Discrimination
Divorce or problems relating to relationship breakdown
Social care
Goods and services you have bought
None of these
Other',1),
                                                           ('Indicator 3: percentage reporting knowledge of rights','Does data exist for UK-born individuals in Wales? No.
Does data exist for migrants in Wales? No.

Questions to ask:

Which of the following best describes your knowledge of ...?

Human Rights Act
Equality Act
Social Services and Well-being Act

Response options for each:

I know nothing at all
I know a little
I know a fair amount
I know a great deal

If you or your organisation are working with migrants in Wales and could ask some of the questions above, we would like to discuss this with you. Please contact us via migrationpolicy@gov.wales for us to arrange a conversation.',1),
                                                           ('Approaches','We know that certain approaches can improve the integration of migrants in terms of education. We encourage relevant organisations to embed the approaches below to support better outcomes.

Provide information about living in Wales (or local areas) which is tailored to your migrant audience and communicate it via community support organisations and community communication channels (e.g. Telegram, Whatsapp, Facebook etc).
Ensure you monitor the uptake of advice services and receipt of information by migrant communities to ensure services are accessible. Take active steps to improve uptake where needed.
Actively consider how to involve migrant communities in registration drives and political participation initiatives.

Swansea produced a Step-by-Step Guide on how to register to vote in multiple languages which was housed on the local authority\'s website. The guide was provided in 10 languages and helped removed a crucial barrier to accessing information. The approach proved successful, and the number of registered qualifying foreign nationals almost doubled from January to April 2022.

Read more about this successful approach in our accompanying case studies document.',1);

insert into rights_FAQs(que,answer,title_id) values
                                                 ('Does data exist for UK-born individuals in Wales regarding voter registration?','Yes, data for UK-born individuals regarding voter registration in Wales is available through official electoral statistics. These statistics help track voter participation rates and show how many eligible voters, including UK-born citizens, are registered to vote. This data helps us understand civic engagement within Wales.',1),
                                                 ('Does data exist for migrants in Wales regarding voter registration?','Yes, there is data for migrants, though it is more segmented. This data includes overseas voters, anonymous voters, opted-out voters, EU citizens, and parliamentary electors by local authority. For the Polish community, this data is particularly important, as many EU migrants, including Polish nationals, are eligible to vote in local elections and referenda. However, registration data for non-EU migrants is less readily available, making it harder to gauge overall participation.',1),
                                                 ('Does data exist for UK-born individuals in Wales regarding the use of advice services?','Yes, the National Survey for Wales collects data about UK-born individuals and their use of advice services. The survey covers areas like housing, welfare benefits, debt, employment, and more. This helps identify which services are most used and whether there are any gaps in service provision.',1),
                                                 ('Does data exist for migrants in Wales regarding the use of advice services?','No, unfortunately, there is no comprehensive data available specifically for Polish or other migrant communities in Wales regarding the use of advice services. This is a significant gap, as it makes it difficult to assess whether migrants are accessing the help they need. Migrants, especially those who are newly arrived or with limited English skills, may face barriers in accessing services such as housing advice, welfare support, or legal assistance.',1),
                                                 ('What questions are asked in the survey to assess the use of advice services?',' The survey asks whether individuals, including migrants, have accessed advice or support in the past 12 months for a range of issues that Polish immigrants may face, including:

Debt: Have you sought help for managing or clearing debt, such as credit cards, loans, or unpaid bills?
Financial matters other than debt: Have you received assistance with budgeting, saving, or managing your finances?
Welfare benefits: Have you accessed support for benefits such as Universal Credit or housing benefits?
Housing: Have you sought help with housing issues, such as finding accommodation or understanding your tenancy rights?
Employment: Have you needed support regarding your rights as an employee, finding a job, or resolving workplace issues?
Discrimination: Have you experienced or sought help regarding discrimination in employment, housing, or public services?
Divorce or problems relating to relationship breakdown: Have you sought advice on family law matters?
Social care: Have you needed support related to health, social care, or the care of a family member?
Goods and services: Have you experienced issues with consumer rights, faulty products, or services?
Other: Have you sought advice on any other issues not listed above?
None of these: Have you not used any advice services in the past year?

These questions help assess whether migrants, including the Polish community, are accessing services that can assist with integration and provide support for common challenges.',1),
                                                 ('Does data exist for UK-born individuals in Wales regarding knowledge of rights?','No, there is no specific data available for UK-born individuals in Wales regarding their knowledge of rights. While there is general awareness of rights in the UK, the lack of segmented data makes it hard to measure the depth of understanding among UK-born citizens about laws like the Equality Act, Human Rights Act, and Social Services and Well-being Act.',1),
                                                 ('Does data exist for migrants in Wales regarding knowledge of rights?','No, there is no data available for migrants, including Polish nationals, specifically regarding knowledge of their rights. For Polish immigrants, this is particularly important, as many may not be fully aware of the protections available to them under UK law. There may also be confusion about the changes to immigration laws, benefits, and access to services since the UKs exit from the EU.',1),
                                                 ('What questions could be asked to assess knowledge of rights?','To better understand how Polish migrants feel about their legal rights, we could ask:

Human Rights Act: How much do you know about your rights, such as the right to life, freedom from discrimination, or the right to a fair trial?
Equality Act: How familiar are you with the law protecting against discrimination in work, housing, and public services based on race, gender, disability, or other characteristics?
Social Services and Well-being Act: How well do you understand your rights regarding access to social services, healthcare, and other support systems in Wales?

Respondents can rate their knowledge as:

I know nothing at all
I know a little
I know a fair amount
I know a great deal

These questions would help identify whether Polish migrants, in particular, understand their rights in relation to key legislation and if they feel equipped to navigate challenges in Wales.',1),
                                                 ('What approaches can improve the integration of migrants, especially the Polish community, in education?','Several key approaches can significantly enhance the integration of Polish migrants in Wales:
Provide tailored information: Clear and accessible information should be provided in Polish, focusing on living and working in Wales. This could cover essential topics like understanding the UK benefits system, knowing your rights in the workplace, housing, and healthcare. Community-based organisations can help distribute this information, especially through platforms like WhatsApp, Facebook, or local Polish-language newspapers.
Monitor advice service uptake: To ensure Polish migrants are using services effectively, it is essential to regularly monitor and assess the accessibility of advice services. This includes providing translation services, offering advice in Polish, and ensuring migrant-specific needs are addressed, such as support for people with limited English skills.
Promote political participation: Encouraging Polish migrants to register to vote and participate in elections is crucial. Initiatives should actively involve Polish community leaders, local organisations, and bilingual materials to make voting accessible and understandable. This could include information about local and national elections, eligibility, and the benefits of participating in the democratic process.',1),
                                                 ('What successful approach was used in Swansea to increase voter registration among migrants, including Polish nationals?','Swansea implemented a highly effective initiative to increase voter registration among migrants by creating a Step-by-Step Guide on how to register to vote. This guide was translated into 10 languages, including Polish, and made available on the local authority''s website. By providing clear instructions in multiple languages, Swansea removed a major barrier for Polish migrants who may not have been familiar with the process or the importance of registration.
As a result, the number of registered foreign nationals increased dramatically, with the number of qualifying foreign nationals nearly doubling between January and April 2022. This approach can serve as a model for other areas looking to engage migrant communities in political participation.
This version is tailored to address the unique needs of the Polish immigrant community in Wales, including barriers to service access, political participation, and understanding legal rights. Let me know if you need any more specific details or adjustments!',1);


delete from housing_questionnaire;
delete from housing_replies;

insert into housing_questionnaire(name, email, message)
VALUES ('Hajar', 'hajarnefaa@gmail.com', 'Hello everyone I am looking for rent. Can you give me any suggestions where to look?'),
       ('Sara', 'sara@gmail.com', 'Dobry wieczór, I want to buy a house what are the documents needed?');

INSERT INTO housing_replies (name, message, question_id)
VALUES
    ('Sara Doe', 'Hello, you can check this website, you may fined some useful info:https://www.gov.wales/migrant-integration-framework-html#135676', 1),
    ('Louise', 'I also have the same question,does anyone have any idea?', 2),
    (NULL, 'Thank you!', 1);

INSERT INTO eventss (title, date, location, category, description, image_url)
VALUES
    ('Music Festival', '2024-12-01', 'Cardiff', 'Music Festival', 'A music festival in Cardiff featuring various artists, come along!.', 'https://cdn.cnn.com/cnnnext/dam/assets/181018143148-krakow-2-super-tease.jpg'),
    ('Art Exhibition', '2024-12-05', 'Swansea', 'Art or Cultural', 'An art exhibition showcasing modern and classic art in Swansea.', 'https://api.culture.pl/sites/default/files/images/imported/HISTORIA/EN/Polish_independence/zaslubiny_polski_z_morzem.jpg'),
    ('Food Festival', '2024-12-10', 'Newport', 'Food or Drink Event', 'A food festival in Newport offering a wide range of cuisines and drinks.', 'https://1.bp.blogspot.com/-SMfBCbqIRVw/WQeJ84XsJ6I/AAAAAAACJ-U/vrT-1o3hwMcTzQIzUuVkwbZqtV6Req00gCLcB/s1600/ca423901817b8b8187c9e9316481b30e.jpg'),
    ('Countryside and Craft', '2025-07-19', 'Merthyr', 'Countryside and Craft', 'A music festival in Cardiff featuring various artists, come along!.', 'https://i.pinimg.com/originals/c6/2a/04/c62a04aa1be3e976994c41b9156acec4.jpg'),
    ('Polish Independence Day', '2024-11-11', 'Caerphilly', 'Polish Independence Day', 'An art exhibition showcasing modern and classic art in Swansea.', 'https://th.bing.com/th/id/R.aacb19bdb4c2d60e19f3ced81d72fdf9?rik=cjOaPk8ek9d3IQ&riu=http%3a%2f%2fi.dailymail.co.uk%2fi%2fpix%2f2013%2f10%2f15%2farticle-2461911-18C20F1300000578-419_964x640.jpg&ehk=CKGaeqsbBLui7jZGegM%2flOCGQGJ8al3rXVbXLdhtvxo%3d&risl=&pid=ImgRaw&r=0'),
    ('Polish Heritage Day', '2025-04-03', 'Glamorgan', 'Polish Heritage Day', 'A food festival in Newport offering a wide range of cuisines and drinks.', 'https://s3-eu-west-1.amazonaws.com/spacehive/b052b5f6-1724-427a-b7b1-06c4db53c5eb_xlarge_dsc-2388.jpg');



DELETE FROM safety;
INSERT INTO polishsite.safety (`name`, `description`, `location`, `link`, `phone`) VALUES ('South-Wales Police', 'The police force responsible for providing public safety and law enforcement across South Wales', 'All of South Wales', 'https://www.south-wales.police.uk/', '999');
INSERT INTO polishsite.safety (`name`, `description`, `location`, `link`, `phone`) VALUES ('Victim Support South Wales', 'A charity for victims of crime. Staff and trained volunteers provide support and help to people who have suffered crimes.', 'Cardiff and Vale', 'https://www.cavamh.org.uk/directories/victim-support-south-wales/', '02920 222000');
INSERT INTO polishsite.safety (`name`, `description`, `location`, `link`, `phone`) VALUES ('Swansea Neighbourhood Watch', 'Neighbourhood Watch involves people getting together with their neighbours to work in partnership with police  to prevent crime.', 'Swansea', 'https://swansea.gov.uk/neighborhoodwatch?lang=en', '0116 402 6111');