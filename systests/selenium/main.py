from selenium import webdriver


driver = webdriver.Firefox()
driver.get("http://localhost:8080")

btn = driver.find_element_by_tag_name('button')
btn.click()

movies = driver.find_elements_by_tag_name('a')
for m in movies:
    m.click()

driver.close()
