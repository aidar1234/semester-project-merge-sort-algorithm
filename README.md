# semester-project-merge-sort-algorithm
В этом репозитории вы найдете реализацию алгоритма сортировки слиянием. В пакете sortAlgorithms находятся 2 класса: для сортировки массива - с главным статическим методом sort (статическим, потому что не нужно создавать экземпляр класса, достаточно вызвать метод у класса и передать в качестве аргумента массив) и для сортировки связного списка (для реализации сортировки я сначала написал класс LinkedList с одной операцией - добавление элемента в конец, потому что этой операции будет вполне достаточно для сортировки. Сортировка начинается с публичного метода sort, который надо вызвать у конкретного экземпляра класса). 
В пакете benchmarking есть класс InputDataCreator, который генерирует случайные числа, но нет пакета data с самими файлами с числами, их я загрузил на гугл диск.
При тестировании сортировки связного списка в параметры программы я вводил -Xss50m, для увеличения стека java до 50 MB, иначе выходила ошибка StackOverflowError.
