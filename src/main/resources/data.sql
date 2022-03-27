/*insert into recipe_project.ingredient (ingredient_id, ingredient_name)
values (1,'salmon');
insert into recipe_project.ingredient (ingredient_id, ingredient_name)
values (2,'tuna');
insert into recipe_project.ingredient (ingredient_id, ingredient_name)
values (3,'oil');
insert into recipe_project.ingredient (ingredient_id, ingredient_name)
values (4,'chicken');

insert into recipe_project.recipe_instruction (instruction_id, instructions)
values (5,'put salmon on another ');
insert into recipe_project.recipe_instruction (instruction_id, instructions)
values (6,'put tuna on another ');
insert into recipe_project.recipe_instruction (instruction_id, instructions)
values (7,'put chicken on another ');


insert into recipe_project.recipe (recipe_id, recipe_name, instruction_id)
values (7,'salmon',5);
insert into recipe_project.recipe (recipe_id, recipe_name, instruction_id)
values (8,'tuna patties',6);
insert into recipe_project.recipe (recipe_id, recipe_name, instruction_id)
values (9,'crispy salmon',5);
insert into recipe_project.recipe (recipe_id, recipe_name, instruction_id)
values (10,'crackpot',7);


insert into recipe_project.recipe_ingredient (recipe_ingredient_id, amount, measurement, ingredient_id, recipe_id)
values (211,1,5,4,7);
insert into recipe_project.recipe_ingredient (recipe_ingredient_id, amount, measurement, ingredient_id, recipe_id)
values (212,1,5,2,10);
insert into recipe_project.recipe_ingredient (recipe_ingredient_id, amount, measurement, ingredient_id, recipe_id)
values (13,1,1,3,7);


insert into recipe_project.recipe_category (recipe_category_id, category)
values (14,'Lunch');
insert into recipe_project.recipe_category (recipe_category_id, category)
values (15,'Salads');
insert into recipe_project.recipe_category (recipe_category_id, category)
values (16,'Breads');
insert into recipe_project.recipe_category (recipe_category_id, category)
values (17,'Holidays');

insert into recipe_project.recipe_recipe_category (recipe_id, recipe_category_id)
values (10,14);
insert into recipe_project.recipe_recipe_category (recipe_id, recipe_category_id)
values (10,17);
insert into recipe_project.recipe_recipe_category (recipe_id, recipe_category_id)
values (7,14);
insert into recipe_project.recipe_recipe_category (recipe_id, recipe_category_id)
values (9,14);
*/