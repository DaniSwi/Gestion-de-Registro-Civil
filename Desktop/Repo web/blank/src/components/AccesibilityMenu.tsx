import React, { useState } from 'react';
import { IonIcon } from '@ionic/react';
import { closeOutline } from 'ionicons/icons';

const AccessibilityMenu: React.FC = () => {
  // El estado ahora vive dentro de su propio componente
  const [showAccesibilidad, setShowAccesibilidad] = useState(false);

  // Estilos centralizados para los botones del menú
  const btnAccesibilidadStyle: React.CSSProperties = {
    backgroundColor: '#0056b3',
    color: 'white',
    border: 'none',
    padding: '12px',
    borderRadius: '8px',
    fontWeight: 'bold',
    fontSize: '14px',
    cursor: 'pointer',
    textAlign: 'left',
    width: '100%',
    transition: 'opacity 0.2s',
    marginBottom: '10px'
  };

  return (
    <> {/* Usamos un Fragmento de React porque estamos devolviendo dos divs paralelos */}
      
      {/* --- BOTÓN FLOTANTE --- */}
      <div 
        onClick={() => setShowAccesibilidad(!showAccesibilidad)}
        style={{ 
          position: 'fixed', 
          right: showAccesibilidad ? '260px' : '0', 
          top: '30%', 
          backgroundColor: '#0056b3', 
          color: 'white', 
          padding: '10px 15px', 
          borderRadius: '8px 0 0 8px', 
          fontSize: '35px', 
          zIndex: 2000, 
          cursor: 'pointer',
          transition: 'right 0.3s ease',
          boxShadow: '-2px 2px 10px rgba(0,0,0,0.2)'
        }}
      >
        {showAccesibilidad ? <IonIcon icon={closeOutline} /> : "♿"}
      </div>

      {/* --- PANEL LATERAL DESPLEGABLE --- */}
      <div style={{
        position: 'fixed',
        right: showAccesibilidad ? '0' : '-260px',
        top: '20%',
        width: '260px',
        backgroundColor: 'white',
        boxShadow: '-4px 0 15px rgba(0,0,0,0.1)',
        borderRadius: '15px 0 0 15px',
        zIndex: 1999,
        transition: 'right 0.3s ease',
        padding: '20px',
        border: '1px solid #e2e8f0'
      }}>
        <h3 style={{ color: '#0056b3', fontWeight: 'bold', borderBottom: '2px solid #0056b3', paddingBottom: '10px', marginBottom: '15px', marginTop: '0' }}>
          Accesibilidad
        </h3>
        
        <div style={{ display: 'flex', flexDirection: 'column' }}>
          <button style={btnAccesibilidadStyle}>Contraste Alto</button>
          <button style={btnAccesibilidadStyle}>Invertir Colores</button>
          <button style={btnAccesibilidadStyle}>Aumentar Texto</button>
          <button style={btnAccesibilidadStyle}>Disminuir Texto</button>
          <button style={btnAccesibilidadStyle}>Subrayar Enlaces</button>
          <button style={btnAccesibilidadStyle}>Fuente Legible</button>
          <button style={{ ...btnAccesibilidadStyle, backgroundColor: '#f1f5f9', color: '#64748b', marginTop: '10px' }}>
            Restablecer
          </button>
        </div>
        
        <p style={{ fontSize: '10px', color: '#94a3b8', marginTop: '15px', textAlign: 'center' }}>
          Ajustes visuales para una mejor experiencia
        </p>
      </div>

    </>
  );
};

export default AccessibilityMenu;