# Language: ru

  @all
  @authorization
  Функция: Авторизация


  Предыстория:
    * Открыта страница по адресу "http://localhost:8080"
    * Нажат пункт меню "Песочница"
    * Нажат пункт "Товары" в выпадающем списке меню "Песочница"

  @carrect
  @TestIt=4725
  Сценарий: Добавление не экзотического овоща с названием из различных символов
    * Выполнено нажатие на кнопку "Добавить"
    * Выполнено нажатие на кнопку "Наименование"
    * В поле введён текст "dghj%:*ГўвЂћвЂ“5ГђВїГђВ°ГђВІГђВ»ГђВї"
    * Нажат выпадающий список под словом "Тип"
    * Нажат пункт "Овощ" в выпадающем списке
    * Установлен чекбокс "Экзотический" в значении false
    * Нажата кнопка сохранить


  @Carrect
  Сценарий: Добавление экзотического фрукта с пустым названием
  * Выполнено нажатие на кнопку "Добавить"
  * Нажат выпадающий список под словом "Тип"
  * Нажат пункт "Овощ" в выпадающем списке
  * Установлен чекбокс "Экзотический" в значении false
   Нажата кнопка сохранить