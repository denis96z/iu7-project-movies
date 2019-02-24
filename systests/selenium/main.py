from selenium import webdriver


driver = webdriver.Firefox()
driver.get("http://localhost:8080")
print(driver.title)
driver.close()
