import React from 'react';
import { IonIcon } from '@ionic/react';
import { 
  hammerOutline, 
  documentTextOutline, 
  videocamOutline 
} from 'ionicons/icons';

const HeaderTop: React.FC = () => {
  // Estilo reutilizable para los enlaces de esta barra
  const linkStyle = {
    display: 'flex',
    alignItems: 'center',
    gap: '5px',
    cursor: 'pointer',
    transition: 'opacity 0.2s'
  };

  return (
    <div style={{ 
      backgroundColor: '#020617', // Un azul muy oscuro/casi negro
      color: '#e2e8f0', // Texto gris claro/blanco
      padding: '8px 40px',
      display: 'flex',
      justifyContent: 'flex-end', // Alinea los elementos hacia la derecha como en la imagen
      gap: '30px', // Separación entre cada enlace
      fontSize: '12px',
      flexWrap: 'wrap' // Permite que se adapte en pantallas más pequeñas
    }}>
      
      <div style={linkStyle}>
        <IonIcon icon={hammerOutline} style={{ fontSize: '14px' }} />
        <span>Plataforma Ley Lobby</span>
      </div>

      <div style={linkStyle}>
        <IonIcon icon={hammerOutline} style={{ fontSize: '14px' }} />
        <span>Solicitud Ley de Transparencia</span>
      </div>

      <div style={linkStyle}>
        <IonIcon icon={documentTextOutline} style={{ fontSize: '14px' }} />
        <span>Transparencia Activa</span>
      </div>

      <div style={linkStyle}>
        <IonIcon icon={documentTextOutline} style={{ fontSize: '14px' }} />
        <span>Decretos</span>
      </div>

      <div style={{ ...linkStyle, color: '#22c55e', fontWeight: 'bold' }}>
        <IonIcon icon={videocamOutline} style={{ fontSize: '14px' }} />
        <span>Observe el Consejo Municipal en VIVO</span>
      </div>

    </div>
  );
};

export default HeaderTop;