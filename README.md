# Top Movies

## Запуск сервиса

```
docker-compose up -d
```

## Системное тестирование

### Подготовка

Linux:

```
./systests/selenium/install.sh
```

### Заполнение базы

```
node ./systests/upload.js
```

### Запуск тестов

```
python ./systests/selenium/main.py
```
