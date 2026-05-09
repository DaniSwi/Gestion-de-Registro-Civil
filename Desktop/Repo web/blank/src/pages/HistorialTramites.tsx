import React, { useState } from 'react';
import {
  IonPage,
  IonContent,
  IonCard,
  IonGrid,
  IonRow,
  IonCol,
  IonIcon
} from '@ionic/react';
import {
  wifi,
  timeOutline,
  checkmarkCircleOutline,
  chevronForwardOutline,
  businessOutline,
  clipboardOutline
} from 'ionicons/icons';

// Importación de tus componentes modulares
import Header from '../components/Header';
import AccessibilityMenu from '../components/AccesibilityMenu';

// Datos simulados para que funcione sin backend en esta entrega parcial
const datosSimulados = [
  { id: 1, titulo: "Inscripción descuento en la compra de gas", estado: "En revisión", departamento: "Qué departamento de la muni se encarga" },
  { id: 2, titulo: "Inscripción descuento en la compra de gas", estado: "Terminado", departamento: "Qué departamento de la muni se encarga" },
  { id: 3, titulo: "Inscripción descuento en la compra de gas", estado: "Terminado", departamento: "Qué departamento de la muni se encarga" },
  { id: 4, titulo: "Inscripción descuento en la compra de gas", estado: "Terminado", departamento: "Qué departamento de la muni se encarga" }
];

const HistorialTramites: React.FC = () => {
  // Estado para manejar la lista de trámites
  const [tramites, setTramites] = useState(datosSimulados);

  // Función para simular la eliminación de un trámite en el frontend
  const handleEliminar = (id: number) => {
    setTramites(tramites.filter(tramite => tramite.id !== id));
  };

  return (
    <IonPage>
      <IonContent color="light">

        {/* --- COMPONENTES GLOBALES IMPORTADOS --- */}
        <Header />
        <AccessibilityMenu />

        {/* --- CONTENIDO ESPECÍFICO DE LA PÁGINA --- */}
        
        {/* 1. Miga de Pan (Breadcrumbs) */}
        <div style={{ padding: '15px 40px', fontSize: '13px', color: '#64748b', display: 'flex', alignItems: 'center' }}>
          <IonIcon icon={chevronForwardOutline} style={{ marginRight: '5px' }} />
          Usted está en: <strong style={{ marginLeft: '5px', color: '#334155', textDecoration: 'underline' }}>Historial de Trámites</strong>
        </div>

        {/* 2. Encabezado de la Sección */}
        <div style={{ padding: '20px 40px', maxWidth: '1200px', margin: '0 auto' }}>
          <h1 style={{ fontWeight: 'bold', color: '#334155', fontSize: '28px', marginBottom: '10px' }}>
            Historial de Trámites
          </h1>
          <p style={{ color: '#94a3b8', fontSize: '16px', marginBottom: '40px', lineHeight: '1.5' }}>
            Aquí podrá encontrar todos los trámites que ha realizado a lo largo del tiempo.<br />
            Podrá modificar, cancelar o revisar el estado de sus trámites.
          </p>

          {/* 3. Listado de Trámites (Grid Responsivo de Ionic) */}
          <IonGrid>
            <IonRow>
              {tramites.map((tramite) => (
                <IonCol size="12" sizeMd="6" key={tramite.id} style={{ padding: '15px' }}>
                  <IonCard style={{ margin: 0, boxShadow: '0 2px 10px rgba(0,0,0,0.05)', borderRadius: '10px', border: '1px solid #f1f5f9', backgroundColor: 'white' }}>
                    
                    {/* Interior de la Tarjeta */}
                    <div style={{ display: 'flex', padding: '25px', gap: '20px' }}>
                      
                      {/* Iconos de la izquierda */}
                      <div style={{ display: 'flex', flexDirection: 'column', alignItems: 'center', gap: '15px', minWidth: '50px' }}>
                        <IonIcon icon={clipboardOutline} style={{ fontSize: '45px', color: '#475569' }} />
                        <IonIcon icon={businessOutline} style={{ fontSize: '20px', color: '#cbd5e1' }} />
                      </div>
                      
                      {/* Textos centrales */}
                      <div style={{ flex: 1 }}>
                        <h3 style={{ fontWeight: 'bold', color: '#475569', fontSize: '16px', marginTop: '5px', marginBottom: '15px', lineHeight: '1.4' }}>
                          {tramite.titulo}
                        </h3>
                        <p style={{ color: '#94a3b8', fontSize: '13px', margin: 0, lineHeight: '1.4' }}>
                          {tramite.departamento}
                        </p>
                      </div>

                      {/* Etiquetas / Badges de estado a la derecha */}
                      <div style={{ display: 'flex', flexDirection: 'column', gap: '10px', minWidth: '150px' }}>
                        <div style={{ backgroundColor: '#fcb864', color: '#7c2d12', padding: '6px 10px', borderRadius: '4px', fontSize: '12px', fontWeight: 'bold', display: 'flex', alignItems: 'center', gap: '5px' }}>
                          <IonIcon icon={wifi} /> Trámite en línea
                        </div>
                        <div style={{ 
                          backgroundColor: tramite.estado === 'Terminado' ? '#10b981' : '#fde047', 
                          color: tramite.estado === 'Terminado' ? 'white' : '#854d0e', 
                          padding: '6px 10px', borderRadius: '4px', fontSize: '12px', fontWeight: 'bold', display: 'flex', alignItems: 'center', gap: '5px' 
                        }}>
                          <IonIcon icon={tramite.estado === 'Terminado' ? checkmarkCircleOutline : timeOutline} /> 
                          {tramite.estado}
                        </div>
                      </div>
                    </div>

                    {/* Botones de acción inferiores */}
                    <div style={{ display: 'flex', justifyContent: 'flex-start', padding: '0 25px 25px 25px', gap: '15px' }}>
                      <button 
                        onClick={() => handleEliminar(tramite.id)} 
                        style={{ backgroundColor: '#fb7185', color: 'white', border: 'none', padding: '10px 30px', borderRadius: '6px', fontWeight: 'bold', cursor: 'pointer' }}
                      >
                        Eliminar
                      </button>
                      <button 
                        style={{ backgroundColor: '#3b82f6', color: 'white', border: 'none', padding: '10px 30px', borderRadius: '6px', fontWeight: 'bold', cursor: 'pointer' }}
                      >
                        Modificar
                      </button>
                    </div>

                  </IonCard>
                </IonCol>
              ))}
            </IonRow>
          </IonGrid>

        </div>
      </IonContent>
    </IonPage>
  );
};

export default HistorialTramites;