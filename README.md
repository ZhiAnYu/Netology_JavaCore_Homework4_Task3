Задача 3: JSON парсер (со звездочкой *)
Описание
В данной задаче вам предстоит произвести чтение файла JSON, его парсинг и преобразование объектов JSON в классы Java.

В ходе выполнения программы в консоле вы должны увидеть следующие строки

> Task :Main.main()
Employee{id=1, firstName='John', lastName='Smith', country='USA', age=25}
Employee{id=2, firstName='Inav', lastName='Petrov', country='RU', age=23}
Реализация
Выполнение задачи следует начать с получения JSON из файла. Сделайте это с помощью метода readString():

String json = readString("new_data.json");
Метод readString() реализуйте самостоятельно с использованием BufferedReader и FileReader. Метод должен возвращать прочитанный из файла JSON типа String.

Прочитанный JSON необходимо преобразовать в список сотрудников. Сделайте это с помощью метода jsonToList():

List<Employee> list = jsonToList(json);
При реализации метода jsonToList() вам потребуются такие объекта как: JSONParser, GsonBuilder, Gson. JSONParser даст вам возможность с помощью метода parse() получить из строчки json массив JSONArray. GsonBuilder будет использован исключительно для создания экземпляра Gson. Пройдитесь циклом по всем элементам jsonArray и преобразуйте все jsonObject в Employee.class с помощью метода gson.fromJson(). Полученные экземпляры класса Employee добавляйте в список, который должен быть выведен из метода после его окончания.

Далее, выведите содержимое полученного списка в консоль. Не забудьте переопределить метод toString() в классе Employee.
