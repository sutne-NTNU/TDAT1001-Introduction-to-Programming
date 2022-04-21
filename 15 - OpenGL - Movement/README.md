# Graphic Assignment 4
Denne oppgaven kan godt gjøres i grupper på to/tre stykker.

Lag en Robot(-menneske) som har føtter, kropp, armer og hode. Bestand-delene i roboten kan være enkle, f.eks. sylindre, kuber osv. Her kan det være lurt å lage en tegning på papir og skrive inn posisjoner på de enkelte robotdelene for så å overføre dette til kode.

Kamera skal kunne rotere rundt slik at man kan se roboten fra forskjellige vinkler. Tanken er først og fremst at kameraet roterer rundt (i verdenen til) roboten. For å få til dette kan man bruke gluLookat() og endre øyeposisjon (de tre første argumentene til metoden) langs en sirkel (rundt roboten). Synsretningen vil hele tiden være mot roboten/origo (det er vel gjerne også naturlig å ha Y-aksen som oppvektor - selv om andre løsninger er mulig). 

Gi roboten mulighet til å bevege seg rundt på skjermen. Dette kan enten være som resultat av tastaturtrykk eller f.eks. en animasjon (hvor roboten går en fast rute - f.eks. fram og tilbake langs X-aksen).

Dette er ikke noe absolutt krav men jeg synes det bør løses: Føttene bør også bevege seg når roboten går. Husk at når man skal rotere føtene så er det viktig at rotasjonen skjer i hofta (og ikke f.eks i kneet). Ergo så må "hoftedelen" av foten være i (modellens) origo ved rotasjonen.

For de som ønsker større utfordringer:
Legg ut noen andre objekter i verdenen som roboten beveger seg i. F.eks. kan det jo være hindringer som
roboten må forholde seg til, kanskje man kan hoppe opp ved bruk av tastatur osv. Her har man jo starten på et spill :-)


Tips:
```java 
gl.glPushMatrix() 
gl.glPopMatrix();
```

Den første metoden lagrer MODEL_VIEW matrisa og den andre vil sette den tilbake til sånn som den var når gl.flPushMatrix() ble kalt. Man kan bruke dette for å hindre at tranformasjoner påhvirker hverandre. F.eks. kan koden for opptegning av føttene se noe slik ut (dette er ikke ment som kjørbar/kompilerbar kode, mer som pseudokode):

```Java
void display(AutoDrawable drawable){
    GL2 gl = drawable.getGL().getGL2(); 
    gl.glClear(GL2.GL_COLOR_BUFFER_BIT | GL2.GL_DEPTH_BUFFER_BIT); // clear color and depth buffers
    gl.glLoadIdentity();  // reset the model-view matrix
    gl.glTraslate(....); //flytter objektet i verden   
    tegnFot(gl,posisjon_venstre_fot,rotasjon_venstre_fot);//VENSTRE FOT
    tegnFot(gl,posisjon_hoyre_fot,rotasjon_hoyre_fot);// HØYRE FOT   
}

void tegnFot(GL2 gl, double[] posisjon, double rotasjon){
    gl.glPushMatrix();//lagrer MODEL_VIEW matrisa
    gl.glTranslatedv(posisjon);
    gl.glRotate(rotasjon,....);   
    //kode for å tegne foten med
    gl.glPopMatrix();//setter MODEL_VIEW matrisa slik den var før metoden ble kalt   
}
```
MERK at transformasjonene som gjøres i de to kallene til tegnFot() ikke vil påvirke hverandre (grunnet gl.glPushMatrix() og gl.glPopMatrix())! Men glTranslate() i display-metoden vil påvirke opptegning av begge føttene! Mao. vil de flyttes like mye og i samme retning av denne translasjonen.

