# InterfazGr-ficaCalculadora

El contenido de este proyecto está compuesto por el desarrollo de la interfaz gráfica de una calculadora como de la lógica que hay detrás de esta para su correcto funcionamiento.

Como herramienta de desarrollo de interfaz de ha utilizado el plugin WindowBuilder de Java para Eclipse. 

A modo de guia para la parte gráfica como para el funcionamiento básico de algunos eventos se ha seguido el tutorial GUI Calculator in JAVA using eclipse ide | Tech Projects. Para toda la parte lógica el desarrollo a sido complemente propio. 

## Situaciones de error tenidas en cuenta.

1.- División por cero.

  Tratamiento:
  Lanzamiento de aviso ("No se puede dividir por cero")
  
2.- Pulsado de botones de operacion consecutivamente. 

  Tratamiento:
  Exceptuando el pulsado de factorial que realizará el factorial del ultimo número el resto de operaciónes pulsadas consecutivamente se dará            prioridad a la última pulsada.
  
3.- Operar con números negativos.

  Tratamiento:
  Será permitido su escritura.

4.- Número con más de un punto decimal.

  Tratamiento:
  No será permitido su escritura. Se lanzará un mensaje de ERROR.
  
5.- Captura de excepciones por problemas de sintaxis. ( Factorial de un número negativo o decimal, primo de un número negativo, ... )

  Tratamiento:
  Se lanzará el correspondiente mensaje de la excepción.

## ¿ Cómo se prueba una interfaz gráfica de usuario ?

Las prueba de interfaces gráficad de usuario se centran en probar la funcionalidad y usabilidad de los distintos componentes que la integran. 

Como hemos mencionado anteriormente estas se dividen en dos grupos:

- Pruebas de funcionalidad: Tienen como fin el probar que las distintas funciones que se proporcionan funcionan de una forma correcta y lógica. Otros de los aspectos que revisan son la funcionalidad entre interfaces y su adecuada interoperabilidad.

- Pruebas de usabilidad: Se encargan de evaluar la facilidad de uso de esta y su comprensión.  

### Pruebas funcionalidad realizadas.

1.- Verificar funcionamiento operación suma.

Situaciones:
1+4=5
1+5+1=7

2.- Verificar funcionamiento operación resta.

Situaciones:
3-1=2.0
2-1-2=-1.0
1.5-0.5=1.0

3.- Verificar funcionamiento operación multiplicación.

Situaciones:
2*5=10.0
2*5*3=30.0
-1*-1=1 (Situación de error)
5*-3=-15.0

4.- Verificar funcionamiento operación división.

Situaciones:
4/2=2.0
4/-2=-2.0
-4/-2=2.0
4/0=No se puede dividir entre cero (Situación de error)

5.- Verificar funcionamiento operación factorial.

Situaciones:
3!=6.0
2+3!=8
2+3!=8+3!=14.0
2.5! Operación factorial no permitida a números decimales (Situación de error)
-2! Operación factorial no permitida a números negativos (Situación de error)
-2.5!  Operación factorial no permitida a números decimales y negativos (Situación de error)

6.- Verificar funcionamiento operación primo.

Situaciones:
5P = Primo = true
3+3P= Primo = false
3-4P = Los números negativos no pueden ser primos
4.4P = Los número decimales no pueden ser primos

7.- Verificar funcionamiento botón ".".

Situaciones:

2.3=2.3
2.3+1=3.3
2.3+1=3.3+0.7=4
2.. ERROR.

8.- Verificar funcionamiento retroceso.

Situaciones:
123 <-<-<- = 0.0
123+123<-<-<- = 123.0


9.- Verifica funcionamiento clear.

Situaciones:
123C = 0.0
123+12C=123.0
123+12CC=0.0

## Características usabilidad tenidas en cuenta

- Misma tipografía en los caractéres
- Color de caractéres en dos grupos. Negro para caractéres de operación u otros y azul oscuro para números. Exceptuamos el botón clear con color rojo. 
- Formato del carácter en dos grupos. Negrita para número y normal para operaciones u otros. 
- Formato del botón "=" en un tono más marcado con el simbolo en un tamaño mayor. 
- Alineamiento uniforme de botones.
- Medidas uniformes excepto en botón "=" por su papel principal.

Con estas modificaciones se ha tenido la intención de facilitar la identificación de las distintas opciones de la calculadora con el agrupamiento tanto por colores como por formato del caracter. Por ejemplo el color rojo del botón clear tiene intención de dar una comnotación de cuidado y el fondo del "=" o el tono de los números facilidad de identificación e diferenciación.




