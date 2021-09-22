export const TRANSLATION = {
    General: {
        active: 'Activé',
        actualPower: 'Puissance de décharge VE',
        apply: 'Apply',
        autarchy: 'Autarcie',
        automatic: 'Automatiquement',
        cancel: 'cancel',
        capacity: 'Capacité',
        numberOfComponents: 'nombre de composants',
        changeAccepted: 'Changement accepté',
        changeFailed: 'Changement échoué',
        chargeDischarge: 'Puissance de Charge/Décharge',
        chargePower: 'Puissance de charge',
        componentInactive: 'Component is not active!',
        connectionLost: 'Connection lost. Trying to reconnect.',
        consumption: 'Consommation',
        cumulative: 'Valeurs cummulées',
        currentName: 'current name',
        currentValue: 'current value',
        dateFormat: 'yyyy-MM-dd', // e.g. German: dd.MM.yyyy (dd = Day, MM = Month, yyyy = Year)
        dischargePower: 'Puissance de décharge',
        digitalInputs: 'Entrées numériques',
        fault: 'Fault',
        grid: 'Réseau',
        gridBuy: 'Acheté sur le réseau',
        gridBuyAdvanced: 'Achete',
        gridSell: 'Vendu sur le réseau',
        gridSellAdvanced: 'Vends',
        history: 'Historique',
        inactive: 'Désactivé',
        info: 'Info',
        inputNotValid: 'Input not valid',
        insufficientRights: 'Droits insuffisants',
        live: 'Direct',
        load: 'Charge',
        manually: 'Manuellement',
        measuredValue: 'Measured Value',
        mode: 'Mode',
        more: 'Plus...',
        noValue: 'Aucune valeurs',
        off: 'Off',
        offGrid: 'Pas de connection au réseau!',
        ok: 'ok',
        on: 'On',
        otherConsumption: 'autre consommation',
        percentage: 'Pourcentage',
        periodFromTo: 'de {{value1}} à {{value2}}', // value1 = beginning date, value2 = end date
        phase: 'Phase',
        phases: 'Phases',
        power: 'Puissance',
        production: 'Production',
        rename: 'Rename',
        reportValue: 'Report corrupted data',
        reset: 'Reset',
        search: 'Recherche',
        selfConsumption: 'Auto Consommation',
        soc: 'état de charge',
        state: 'Etat',
        storageSystem: 'Système de stockage',
        systemState: 'System state',
        total: 'total',
        totalState: 'Total state',
        warning: 'Warning',
        Week: {
            monday: 'Lundi',
            tuesday: 'Mardi',
            wednesday: 'Mercredi',
            thursday: 'Jeudi',
            friday: 'Vendredi',
            saturday: 'Samedi',
            sunday: 'Dimanche'
        },
        Month: {
            january: 'January',
            february: 'February',
            march: 'March',
            april: 'April',
            may: 'May',
            june: 'June',
            july: 'July',
            august: 'August',
            september: 'September',
            october: 'October',
            november: 'November',
            december: 'December',
        },
    },
    Menu: {
        aboutUI: 'à propos de OpenEMS UI',
        accessLevel: 'Niveau d\'accès',
        edgeSettings: 'Réglages de FEMS',
        generalSettings: 'Réglages généraux',
        index: 'Index',
        logout: 'Déconnexion',
        menu: 'Menu',
        name: 'Nom',
        overview: 'Apperçu FEMS ',
        profile: 'Utilisateur',
        settings: 'Réglages',
        changelog: 'Changelog',
    },
    Index: {
        allConnected: 'Toutes les connections sont établies.',
        connectionInProgress: 'Établir la connexion...',
        connectionSuccessful: 'Connecté avec succès à {{value}}.', // value = name of websocket
        connectionFailed: 'Connection avec {{value}} échouée.', // value = name of websocket
        deviceOffline: 'Ld\'appareil n d\'est pas connecté!',
        isOffline: 'OpenEMS est hors ligne!',
        loggedInAs: 'Enregistré en tant que:',
        toEnergymonitor: 'Vers le moniteur d\'énergie...',
        type: 'Type:'
    },
    Edge: {
        Index: {
            Energymonitor: {
                activePower: 'Puissance Active',
                consumptionWarning: 'Consommation & production inconnue',
                gridMeter: 'Compteur Réseau',
                productionMeter: 'Compteur production',
                reactivePower: 'Puissance Réactive',
                storage: 'Stockage',
                storageCharge: 'Stockage-Charge',
                storageDischarge: 'Stockage-Décharge',
                title: 'Moniteur d\'énergie',
            },
            Energytable: {
                title: 'Tableau énergétique',
                loadingDC: 'Charge DC',
                productionDC: 'Production DC'
            },
            Widgets: {
                autarchyInfo: 'L\'AUtarcie indique le pourcentage de la puissance actuelle qui peut être couverte par la production et la décharge du stockage.',
                phasesInfo: 'Pour des raisons technique, la somme des phases individuelles peut être légerement différente de la somme totale.',
                selfconsumptionInfo: 'L\'auto-consommation indique le pourcentage de la puissance générée actuellement qui peut être utilisé par une consommation directe et une recharge du stockage.',
                twoWayInfoGrid: "Les valeurs négatives correspondent à l'alimentation du réseau, Les valeurs positives correspondent à l'alimentation secteur",
                InfoStorageForCharge: 'Les valeurs négatives correspondent au chargement de la mémoire',
                InfoStorageForDischarge: 'Les valeurs positives correspondent à une décharge de la mémoire',
                Channeltreshold: {
                    output: 'Output'
                },
                Singlethreshold: {
                    above: 'Above',
                    behaviour: 'Behaviour',
                    below: 'Below',
                    currentValue: 'Current value',
                    dependendOn: 'Dependend on',
                    minSwitchingTime: 'Minimum swichting time',
                    moreThanMaxPower: 'La valeur ne doit pas être inférieure à la puissance maximale de l appareil contrôlé',
                    other: 'Other',
                    relationError: 'Threshold must be greater than the switched load power',
                    switchedLoadPower: 'Switched load power',
                    switchOffAbove: 'Switch off above',
                    switchOffBelow: 'Switch off below',
                    switchOnAbove: 'Switch on above',
                    switchOnBelow: 'Switch on below',
                    threshold: 'Threshold',
                },
                DelayedSellToGrid: {
                    sellToGridPowerLimit: 'Charge ci-dessus',
                    continuousSellToGridPower: 'Décharge ci-dessous',
                    relationError: 'La limite de charge doit être supérieure à la limite de décharge',
                },
                Peakshaving: {
                    asymmetricInfo: 'The entered performance values ​​refer to individual phases. It is adjusted to the most stressed phase.',
                    endDate: 'Date de fin',
                    endTime: 'Heure de fin',
                    mostStressedPhase: 'Most stressed phase',
                    peakshaving: 'Peak-Shaving',
                    peakshavingPower: 'Discharge above',
                    recharge: 'Puissance de charge',
                    rechargePower: 'Charge below',
                    relationError: 'Discharge limit must be greater than or equal to the load limit',
                    startDate: 'Date de début',
                    startTime: 'Heure de début',
                    startTimeCharge: 'Heure de début du chargement',
                },
                GridOptimizedCharge: {
                    considerGridFeedInLimit: 'Tenir compte de l\'injection maximale du réseau',
                    endTime: 'Heure de fin',
                    endTimeDescription: 'La charge n\'a pas lieu avec la quantité maximale pendant quelques heures, mais régulièrement sur une plus longue période de temps.',
                    endTimeDetailedDescription: 'Le chargement n\'a pas lieu avec la puissance maximale pendant quelques heures, mais régulièrement avec un maximum de {{value1}} à {{value2}} heures.', // value1 = maximum charge, value2 = end time
                    endTimeLong: 'Heure de fin du chargement restreint',
                    expectedSoc: 'État de charge prévu',
                    expectedSocWithoutSellToGridLimit: 'Sans éviter l\'injection maximale du réseau',
                    gridFeedInLimitationAvoided: 'Limitation de l\'alimentation du réseau évitée',
                    gridOptimizedChargeDisabled: 'Charge optimisée pour le réseau désactivée',
                    high: 'Haute',
                    History: {
                        batteryChargeGridLimitDescription: 'L\'alimentation maximale du réseau, au-delà de laquelle la charge des batteries est augmentée (dans la mesure du possible), est inférieure à l\'alimentation maximale autorisée du réseau afin d\'éviter une réduction prématurée de la production.',
                        priorityDescription: 'La charge minimale de la batterie a une priorité plus élevée que la charge maximale de la batterie.',
                    },
                    low: 'Faible',
                    maximumCharge: 'Charge maximale',
                    maximumGridFeedIn: 'Alimentation réseau maximale autorisée',
                    medium: 'Moyen',
                    minimumCharge: 'Charge minimale',
                    RiskDescription: {
                        Low: {
                            functionDescription: 'Chargement relativement précoce du magasin',
                            storageDescription: 'Plus grande probabilité que la mémoire soit complètement chargée',
                            pvCurtail: 'Plus faible probabilité que la réduction du système PV soit évitée',
                        },
                        Medium: {
                            functionDescription: 'Chargement relativement uniforme du magasin',
                            storageDescription: 'Forte probabilité que le stockage soit complètement chargé',
                            pvCurtail: 'Forte probabilité que la réduction du système PV soit évitée',
                        },
                        High: {
                            functionDescription: 'Charge relativement tardive du système de stockage',
                            storageDescription: 'Moins de probabilité que le système de stockage soit complètement chargé',
                            pvCurtail: 'Probabilité plus élevée que la réduction du système PV sera évitée',
                        },
                    },
                    riskPropensity: 'Propension au risque',
                    settingOnlyVisableForInstaller: 'Ce paramètre n\'est visible que par l\'installateur',
                    State: {
                        chargeLimitActive: 'Limite de chargement active',
                        endTimeNotCalculated: 'Heure de fin non calculée',
                        gridFeedInLimitationIsAvoided: 'La limitation Grid-Feed-in est évitée',
                        noLimitActive: 'Aucune limite de chargement active',
                        noLimitPossible: 'Aucune limitation possible (limitée par des contrôles de priorité plus élevée)',
                        notDefined: 'Non défini',
                        passedEndTime: 'Heure de fin du chargement limité dépassée',
                        storageAlreadyFull: 'Mémoire déjà pleine',
                    },
                },
                CHP: {
                    highThreshold: 'Seuil Haut',
                    lowThreshold: 'Seuil Bas',
                },
                EVCS: {
                    activateCharging: 'Activer la sation de recharge',
                    amountOfChargingStations: 'Quantité de stations de rehcarge',
                    cable: 'Cable',
                    cableNotConnected: 'Le câble n\'est pas connecté',
                    carFull: 'CLa voiture est remplie',
                    chargeLimitReached: 'Limite de charge atteinte',
                    chargeMode: 'Charge Mode',
                    chargeTarget: 'Charge target',
                    charging: 'En charge',
                    chargingLimit: 'Limite de recharge',
                    chargingPower: 'Puissance de recharge',
                    chargingStation: 'Station de recharge',
                    chargingStationCluster: 'Ensemble de stations de recharge',
                    chargingStationDeactivated: 'Station de recharge désactivée',
                    chargingStationPluggedIn: 'Station de charge branchée',
                    chargingStationPluggedInLocked: 'Station de recharge branchée + verrouillée.',
                    chargingStationPluggedInEV: 'Station de recharge + EV branchée.',
                    chargingStationPluggedInEVLocked: 'Station de recharge + EV branchée + Verrouillée',
                    clusterConfigError: 'Une erreur s\'est produite dans la configuration du cluster de stations de recharge',
                    currentCharge: 'Reharge actuelle',
                    energySinceBeginning: 'Energie depuis le début de la dernière recharge',
                    energyLimit: 'Limite d\'énergie',
                    enforceCharging: 'Appliquer la charge',
                    error: 'Erreur',
                    maxEnergyRestriction: 'Energie maximum par recharge',
                    notAuthorized: 'Pas Authorisé',
                    notCharging: 'Pas en charge',
                    notReadyForCharging: 'Pas prêt pour la recharge',
                    overviewChargingStations: 'Appercu des stations de recharge',
                    prioritization: 'Priorisation',
                    readyForCharging: 'Prêt pour la recharge',
                    starting: 'Démarrage',
                    status: 'Status',
                    totalCharge: 'Recharge totale',
                    totalChargingPower: 'Puissance de recharge totale',
                    unplugged: 'Débranché',
                    NoConnection: {
                        description: 'Pas de connection à la station de recharge.',
                        help1_1: 'L\'IP de la station de recharge apparait lorsqu\'elle s\'allume de nouveau',
                        help1: 'Vérifiez si la station de recharge est allimée et qu\'elle peut être atteinte via le réseau.',
                    },
                    OptimizedChargeMode: {
                        info: 'Dans ce mode la charge de la voiture est ajustée à la productione t consommation actuelle.',
                        minCharging: 'Recharge minimum garantie',
                        minChargePower: 'taux de charge minimum',
                        minInfo: 'Si vous voulez éviter que la voiture ne charge pas durant la nuit, vous pouvez régler une charge minimum.',
                        name: 'Recharge Optimisée',
                        shortName: 'Automatiquement',
                        ChargingPriority: {
                            car: 'Voiture',
                            info: 'En fonction de la priorisation, le composant sélectionné sera rechargé en premier',
                            storage: 'Stockage'
                        }
                    },
                    ForceChargeMode: {
                        info: 'Dans ce mode, la recharge de la voiture est forcée, i.e. il est toujours garanti que la voiture sera chargée, même si la station de recharge à besoin de la puissance du réseau.',
                        maxCharging: 'Puissance de recharge maximum',
                        maxChargingDetails: 'Si la voiture ne peut accepter la valeur maximum, la puissance sera automatiquement limitée.',
                        name: 'Recharge forcée',
                        shortName: 'Mannuellement',
                    }
                },
                Heatingelement: {
                    heatingelement: 'Heating element',
                    priority: 'Priority',
                    activeLevel: 'Active level',
                    energy: 'Energy',
                    time: 'Time',
                    endtime: 'Endtime',
                    minimalEnergyAmount: 'Minimal charge amount',
                    minimumRunTime: 'Minimum runtime',
                    timeCountdown: 'time until start',
                },
                HeatPump: {
                    aboveSoc: 'et sur l état de charge de',
                    belowSoc: 'et en charge de',
                    gridBuy: 'De l achat du réseau de',
                    gridSell: 'Par excès d alimentatio de',
                    lock: 'Fermer à clé',
                    moreThanHpPower: 'La valeur ne doit pas être inférieure à la puissance maximale de la pompe à chaleur',
                    normalOperation: 'Fonctionnement normal',
                    normalOperationShort: 'Normal',
                    relationError: 'La valeur excédentaire de la commande de mise en marche doit être supérieure à la valeur recommandée de mise en marche',
                    switchOnCom: 'Commande de mise en marche',
                    switchOnComShort: 'Commenade',
                    switchOnRec: 'Recommandation de mise en marche',
                    switchOnRecShort: 'Recommandation',
                    undefined: 'Indéfinie',
                }
            }
        },
        History: {
            activeDuration: 'Durée active',
            beginDate: 'Sélectionnez la date de début',
            day: 'Jour',
            endDate: 'Sélectionnez la date de fin',
            export: 'télécharger sous format excel',
            go: 'Go!',
            lastMonth: 'Le mois passé',
            lastWeek: 'Semaine dernière',
            lastYear: 'L\'année passée',
            month: 'Mois',
            noData: 'Pas de données disponible',
            otherPeriod: 'Autre période',
            period: 'Période',
            selectedDay: '{{value}}',
            selectedPeriod: 'Période sélectionnée: ',
            today: 'Aujourd\'hui',
            week: 'Semaine',
            year: 'Année',
            yesterday: 'Hier',
            sun: 'Dim',
            mon: 'Lun',
            tue: 'Mar',
            wed: 'Mer',
            thu: 'Jeu',
            fri: 'Ven',
            sat: 'Sam',
            jan: 'Jan',
            feb: 'Fév',
            mar: 'Mar',
            apr: 'Avr',
            may: 'Mai',
            jun: 'Jun',
            jul: 'Jul',
            aug: 'Aou',
            sep: 'Sep',
            oct: 'Oct',
            nov: 'Nov',
            dec: 'Dec'
        },
        Config: {
            Index: {
                addComponents: 'Installez des componsants',
                adjustComponents: 'Configurez des composants',
                bridge: 'Connections et appareils',
                controller: 'Applications',
                dataStorage: 'Donnée du stockage',
                executeSimulator: 'Executez les simulations',
                liveLog: 'Live system log',
                log: 'Log',
                manualControl: 'Contrôle manuel',
                renameComponents: 'Rename components',
                scheduler: 'Applicationplanner',
                simulator: 'Simulateur',
                systemExecute: 'Exécutez une commande système',
                systemProfile: 'System Profile',
            },
            More: {
                manualCommand: 'Commande Manuelle',
                manualpqPowerSpecification: 'Spécification de puissance',
                manualpqReset: 'Reset',
                manualpqSubmit: 'Soumettre',
                refuInverter: 'REFU Inverter',
                refuStart: 'Start',
                refuStartStop: 'Start/Stop inverter',
                refuStop: 'Stop',
                send: 'Envoyer',
            },
            Scheduler: {
                always: 'Toujours',
                class: 'Class:',
                contact: 'Ceci ne devrait pas arriver. merci de contacter <a href=\'mailto:{{value}}\'>{{value}}</a>.',
                newScheduler: 'New scheduler...',
                notImplemented: 'Formulaire non implanté: ',
            },
            Log: {
                automaticUpdating: 'Mise à jour automatique',
                level: 'Level',
                message: 'Message',
                source: 'Source',
                timestamp: 'Timestamp',
            },
            Controller: {
                app: 'App:',
                internallyID: 'Internally ID:',
                priority: 'Priorité:'
            },
            Bridge: {
                newConnection: 'Nouvelle connexion...',
                newDevice: 'Nouvel appareil...',
            }
        },
        Service: {
            entireSystem: "système entier",
            Cell: {
                voltages: "Tensions de cellules",
                temperatures: "Températures des cellules",
                insulation: "Isolement",
            }
        }
    },
    About: {
        build: 'This build',
        contact: 'Veuillez contacter notre équipe pour plus d\'informations ou suggestions sur le système à l\'adresse<a href =\'mailto:{{value}}\'>{{value}}</a>.',
        currentDevelopments: 'Développement actuels',
        developed: 'Cet interface utilisateur est développé en tant que logiciel libre.',
        language: 'Sélectionnez la langue:',
        openEMS: 'Plus au sujet d\'OpenEMS',
        ui: 'interface utilisateur pour OpenEMS',
    },
    Notifications: {
        authenticationFailed: 'Pas de connexion, échec d\'authentification .',
        closed: 'Connecxion fermée.',
        failed: 'Connexion échouée.',
        loggedIn: 'Enregistré.',
        loggedInAs: 'Enregistré sous as \'{{value}}\'.', // value = username
    }
}
